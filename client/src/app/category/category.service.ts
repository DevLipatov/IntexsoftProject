import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import Category from "../model/category";
import ICategoryService from "./icategory.service";
import 'rxjs/add/operator/toPromise';
import "rxjs/add/operator/catch";

/**
 * Implementation of ICategoryService
 */
@Injectable()
export class CategoryService implements ICategoryService {

  constructor(private http: Http) {
  }

  findAll(): Promise<Category[]> {
    return this.http.get('api/categories')
      .toPromise()
      .then(response => response.json());
  }

  add(category: Category): Promise<Category> {
    return this.http.post('api/category-add', category)
      .toPromise()
      .then(response=> response.json())
      .catch();
  }
}
