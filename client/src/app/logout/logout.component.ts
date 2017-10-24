import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import "rxjs/add/observable/timer";
import {Router} from "@angular/router";

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router) {
  }

  ngOnInit() {
    let timer = Observable.timer(3000);
    timer.subscribe(then => this.goHome());
  }

  goHome() {
    this.router.navigate(['home']);
  }
}
