import {Component, Inject, OnInit} from '@angular/core';
import User from "../model/user";
import ILoginService from "./ilogin.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User;

  constructor(@Inject('loginService') private loginService: ILoginService,
              private router: Router,) {
  }

  ngOnInit() {
  }

  onLoginClick() {
    this.loginService.log(this.user)
      .then(result => {
        localStorage.setItem("username", result.username);
        localStorage.setItem("role", result.role);
        localStorage.setItem("token", result.token);
        this.router.navigate(['home']);
      })
      .catch((e: Error) => alert(e.message));
  }
}
