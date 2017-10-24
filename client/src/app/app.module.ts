import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpModule} from '@angular/http';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from "@angular/forms";
import {MaterialModule} from "./material/material.module";
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AppComponent} from './app.component';
import {ThemeComponent} from './theme/theme.component';
import {CategoryComponent} from './category/category.component';
import {LoginComponent} from './login/login.component';
import {ToolbarComponent} from './toolbar/toolbar.component';
import {RegisterComponent} from './register/register.component';
import {HomeComponent} from './home/home.component';
import {AdminComponent} from './admin/admin.component';
import {ThemeCreateComponent} from './theme-create/theme-create.component';
import {LogoutComponent} from './logout/logout.component';

import {CategoryService} from "./category/category.service";
import {ThemeService} from "./theme/theme.service";
import {RegisterService} from "./register/register.service";
import {ThemeCreateService} from "./theme-create/theme-create.service";
import {LoginService} from "./login/login.service";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'theme-create',
    component: ThemeCreateComponent
  },
  {
    path: 'administration',
    component: AdminComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'logout',
    component: LogoutComponent
  }
]

const URL_I18N_FILES = './assets/i18n/';
const FILE_FORMAT = '.json';

/**
 * @param {HttpClient} http - an object of type HttpClient which has methods
 * to perform http requests
 * @returns {TranslateHttpLoader} - wrapper object, which in essence uses
 * underlying HttpClient to load translations via http protocol
 */
export function HttpLoaderFactory(http: HttpClient): TranslateLoader {
  return new TranslateHttpLoader(http, URL_I18N_FILES, FILE_FORMAT);
}

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CategoryComponent,
    ThemeComponent,
    ToolbarComponent,
    RegisterComponent,
    HomeComponent,
    ThemeCreateComponent,
    AdminComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    HttpClientModule,
    MaterialModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(routes, {enableTracing:true}),
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    })
  ],
  providers: [{provide: "categoryService", useClass: CategoryService},
    {provide: "themeService", useClass: ThemeService},
    {provide: "registerService", useClass: RegisterService},
    {provide: "themeCreateService", useClass: ThemeCreateService},
    {provide: "loginService", useClass: LoginService}],
  bootstrap: [AppComponent]
})

export class AppModule {
}
