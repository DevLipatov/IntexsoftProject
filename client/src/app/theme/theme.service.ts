import {Injectable} from '@angular/core';
import IThemeService from "./itheme.service";
import {Http} from "@angular/http";
import Theme from "../model/theme";

/**
 * Implementation of IThemeService
 */
@Injectable()
export class ThemeService implements IThemeService {

  constructor(private http: Http) {
  }

  findAllThemes(): Promise<Theme[]> {
    return this.http.get('/intexsoft/api/themes/published')
      .toPromise()
      .then(response => response.json());
  }

  findPublishedByCategoryName(category: String): Promise<Theme[]> {
    return this.http.get('/intexsoft/api/themes/published/' + category)
      .toPromise()
      .then(response => response.json());
  }

  findAllNewThemes(): Promise<Theme[]> {
    return this.http.get('/intexsoft/api/themes/new')
      .toPromise()
      .then(response => response.json());
  }

  findAllDeletedThemes(): Promise<Theme[]> {
    return this.http.get('/intexsoft/api/themes/deleted')
      .toPromise()
      .then(response => response.json());
  }

  deleteById(id: number): Promise<Theme> {
    return this.http.get('/intexsoft/api/theme/delete/' + id)
      .toPromise()
      .then(response => response.json());
  }
}
