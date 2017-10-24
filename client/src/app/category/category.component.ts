import {Component, Inject, OnInit} from '@angular/core';
import ICategoryService from "./icategory.service";
import Category from "../model/category";
import {MdSnackBar} from "@angular/material";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css'],
})

export class CategoryComponent implements OnInit {

  categories: Category[];
  newCategory: Category = new Category;
  selectedCategoryName: String;
  role:string = localStorage.getItem("role");
  isAdmin: boolean = this.role == "ROLE_ADMIN";
  isLogged: boolean = this.role != null;

  ngOnInit(): void {
    this.find();
    this.selectedCategoryName = "Drams"
  }

  constructor(@Inject('categoryService') private categoryService: ICategoryService,
              public snackBar: MdSnackBar) {
  }

  /**
   * Find all categories in database
   */
  find() {
    this.categoryService.findAll()
      .then(result => this.categories = result)
      .catch((e: Error) => alert(e.message));
  }

  /**
   * Add new category to database
   */
  add() {
    this.newCategory.themes = null;
    // this.categoryService.add(this.newCategory);
    this.categoryService.add(this.newCategory)
      .then(result =>
        this.snackBar.open("Category successfully created", "Close", {duration: 8000}))
      .catch(error =>
        this.snackBar.open("Cann`t add category", "Close", {duration: 8000}))
  }

  /**
   * Set category name to parameter for theme search in theme component
   * @param {Category} category - selected category
   */
  onCategorySelect(category: Category) {
    this.selectedCategoryName = category.name;
  }

}
