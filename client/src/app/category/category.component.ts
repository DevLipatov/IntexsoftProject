import {Component, Inject} from '@angular/core';
import ICategoryService from "./icategory.service";
import Category from "../model/category";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})

export class CategoryComponent {
  categories: Category[];

  constructor(@Inject('categoryService') private categoryService: ICategoryService) {
  }

  find() {
    this.categories = [];
    this.categoryService.findAll()
      .then(result => this.categories = result)
      .catch((e: Error) => alert(e.message));
  }
}
