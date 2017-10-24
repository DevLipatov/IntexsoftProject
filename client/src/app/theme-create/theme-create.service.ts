import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import Theme from "../model/theme";
import IThemeCreateService from "./itheme-create.service";

/**
 * Realisation of IThemeCreateService
 */
@Injectable()
export class ThemeCreateService implements IThemeCreateService {

  constructor(private http: Http) {
  }

  add(theme: Theme): Promise<Theme> {
    return this.http.post('/intexsoft/api/theme-add', theme)
      .toPromise()
      .then(response => response.json());
  }
}
