import {Injectable} from '@angular/core';
import {Http, RequestOptions} from "@angular/http";
import User from "../model/user";
import IRegisterService from "./iregister.service";

/**
 * Realisation of IRegisterService
 */
@Injectable()
export class RegisterService implements IRegisterService{

  constructor(private http: Http) {
  }

  add(user: User): Promise<User> {
    const myHeaders = new Headers({
      'Content-Type': 'application/json'
    });
    const options = new RequestOptions(myHeaders);
    return this.http.post('api/register', user, options)
      .toPromise()
      .then(response => response.json());
  }
}
