import {Component, Inject, OnInit} from '@angular/core';
import Theme from "../model/theme";
import Category from "../model/category";
import ICategoryService from "../category/icategory.service";
import IThemeCreateService from "./itheme-create.service";
import {Router} from "@angular/router";
import {MdSnackBar} from "@angular/material";

@Component({
  selector: 'app-theme-create',
  templateUrl: './theme-create.component.html',
  styleUrls: ['./theme-create.component.css']
})

export class ThemeCreateComponent implements OnInit {

  newTheme: Theme = new Theme;
  categories: Category[];

  constructor(@Inject('categoryService') private categoryService: ICategoryService,
              @Inject('themeCreateService') private themeCreateService: IThemeCreateService,
              private router: Router,
              public snackBar: MdSnackBar) {
  }

  ngOnInit() {
    this.find()
  }

  /**
   * Get all categories from database
   */
  find() {
    this.categoryService.findAll()
      .then(result => this.categories = result)
      .catch((e: Error) => alert(e.message));
  }

  /**
   * Save new theme to database
   */
  onAddThemeClick() {
    this.newTheme.status = "new";
    this.themeCreateService.add(this.newTheme)
      .then(result => {
        this.snackBar.open("Theme successfully created", "Close", {duration: 8000});
        this.router.navigate(['home'])
      });
  }
}
