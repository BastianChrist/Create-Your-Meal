import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {LoginService} from "./service/login.service";
import {LoginComponent} from "./login/login.component";
import { AppRoutingModule } from './app-routing.module';
import { StorageServiceModule} from 'angular-webstorage-service';
import {ContextComponent} from "./context/context.component";
import {ScaleComponent} from "./scale/scale.component";
import {RecipeList} from "./recipe-list/recipe-list";




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ContextComponent,
    ScaleComponent,
    RecipeList
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    StorageServiceModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
