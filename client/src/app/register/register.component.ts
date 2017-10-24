import {Component, Inject} from '@angular/core';
import User from "../model/user";
import IRegisterService from "./iregister.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent {

  newUser: User = new User;

  constructor(@Inject('registerService') private registerService: IRegisterService,
              private router: Router) {
  }

  /**
   * Save new user to database
   */
  add(): void {
    this.registerService.add(this.newUser)
      .then(responce => this.router.navigate(['home']));
  }
}
