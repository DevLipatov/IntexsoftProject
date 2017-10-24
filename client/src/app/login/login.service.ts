import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import 'rxjs/add/operator/toPromise';
import "rxjs/add/operator/catch";
import ILoginService from "./ilogin.service";
import User from "../model/user";
import TokenObject from "../model/tokenobject";

/**
 * Realisation of ILoginService
 */
@Injectable()
export class LoginService implements ILoginService {

  constructor(private http: Http) {
  }

  log(user: User): Promise<TokenObject> {
    return this.http.post('api/login', user).toPromise()
      .then(response => response.json())
      .catch();
  }

  logout(): void {
    localStorage.removeItem("role");
    localStorage.setItem("username", "Guest");
  }

}

