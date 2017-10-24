import {Component, Inject, OnInit} from '@angular/core';
import ILoginService from "../login/ilogin.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})

export class ToolbarComponent implements OnInit {

  role: string = localStorage.getItem("role");
  username: string = localStorage.getItem("username");
  isAdmin: boolean;
  isResearcher: boolean;
  isLogged: boolean;

  constructor(@Inject('loginService') private loginService: ILoginService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.checkRoles();
  }

  /**
   * Check roles to show elements
   */
  checkRoles() {
    this.isAdmin = this.role == "ROLE_ADMIN";
    this.isResearcher = this.role == "ROLE_RESEARCHER";
    this.isLogged = this.role != null;
  }

  /**
   * Log user out
   */
  logOut(): void {
    this.loginService.logout();
    this.isLogged = false;
    this.isAdmin = false;
    this.isResearcher = false;
    this.username = "Guest";
    this.router.navigate(['logout']);
  }
}
