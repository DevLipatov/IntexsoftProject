import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import Category from "../model/category";
import ICategoryService from "./icategory.service";

@Injectable()
export class CategoryService implements ICategoryService{

  constructor(private http: Http) {
  }

  findAll(): Promise<Category[]> {
    return this.http.get('/intexsoft/api/categories')
      .toPromise()
      .then(response => response.json());
  }
}
