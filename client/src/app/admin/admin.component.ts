import {Component, Inject, OnInit} from '@angular/core';
import IThemeService from "../theme/itheme.service";
import Theme from "../model/theme";
import {MdSnackBar} from "@angular/material";
import IThemeCreateService from "../theme-create/itheme-create.service";
import ICategoryService from "../category/icategory.service";
import Category from "../model/category";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  themes: Theme[];
  showDetailsFlag: boolean = false;
  selectedTheme: Theme;
  categories: Category[];
  statuses = ["new", "published", "deleted"];
  role: string = localStorage.getItem("role");
  isAdmin: boolean;
  isResearcher: boolean;

  constructor(@Inject('themeService') private themeService: IThemeService,
              @Inject('themeCreateService') private themeCreateService: IThemeCreateService,
              @Inject('categoryService') private categoryService: ICategoryService,
              public snackBar: MdSnackBar) { }

  ngOnInit() {
    this.findCategories();
    this.findNew();
    this.checkRoles();
  }

  /**
   * Find all categories in database
   */
  findCategories() {
    this.categoryService.findAll()
      .then(result => this.categories = result)
      .catch((e: Error) => alert(e.message));
  }

  /**
   * Find all themes with status "new" in database
   */
  findNew() {
    this.themeService.findAllNewThemes()
      .then(result => this.themes = result);
  }

  /**
   * Find all themes with status "deleted" in database
   */
  findDeleted() {
    this.themeService.findAllDeletedThemes()
      .then(result => this.themes = result);
  }

  /**
   * Set role flags
   */
  checkRoles(): void {
    this.isAdmin = this.role == "ROLE_ADMIN";
    this.isResearcher = this.role == "ROLE_RESEARCHER";
  }

  /**
   * Show theme details to manage them
   * @param {Theme} theme - selected theme
   */
  onManageClick(theme: Theme) {
    this.selectedTheme = theme;
    this.showDetailsFlag = true;
  }

  /**
   * Close details
   */
  onCloseClick() {
    this.showDetailsFlag = false;
  }

  /**
   * Save changes of managed theme
   */
  onSaveClick() {
    this.themeCreateService.add(this.selectedTheme)
      .then(result => {
        this.snackBar.open("Theme successfully saved", "Close", {duration: 8000});
        this.showDetailsFlag = false;
      });
    this.ngOnInit();
  }
}
