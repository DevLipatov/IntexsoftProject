import {Component, Inject, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import IThemeService from "./itheme.service";
import Theme from "../model/theme";

@Component({
  selector: 'app-theme',
  templateUrl: './theme.component.html',
  styleUrls: ['./theme.component.css']
})

export class ThemeComponent implements OnInit, OnChanges {

  @Input() parentData: String;
  themes: Theme[];
  showDetails: boolean = false;
  currentTheme: Theme;
  role: string = localStorage.getItem("role");
  isLogged: boolean = this.role !== null;
  isAdmin: boolean = this.role == "ROLE_ADMIN";

  ngOnInit(): void {
    this.findByCategory(this.parentData);
    this.role = localStorage.getItem("role");
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.findByCategory(changes.parentData.currentValue);
  }

  constructor(@Inject('themeService') private themeService: IThemeService) {
  }

  /**
   * Get all themes from database
   */
  find() {
    this.themeService.findAllThemes()
      .then(result => this.themes = result)
    // .catch((e: Error) => alert(e.message))
    ;
  }

  /**
   * Find themes in database by their category
   * @param {String} name - category name
   */
  findByCategory(name: String) {
    this.themeService.findPublishedByCategoryName(name)
      .then(result => this.themes = result)
  }

  /**
   * Show details, hide
   * @param {Theme} theme
   */
  onDetailsClick(theme: Theme): void {
    this.showDetails = true;
    this.currentTheme = theme;
  }

  /**
   * Delete theme by it id
   * @param {number} id - id of the theme
   */
  onDeleteClick(id: number) {
    this.themeService.deleteById(id)
      .then(result => {
        alert("Theme " + result.title + "is deleted");
        this.findByCategory(this.parentData)
      });
  }

  onHideDetails() {
    this.showDetails = false;
  }
}
