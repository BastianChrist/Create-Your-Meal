import { NgModule } from '@angular/core';
import {Routes, RouterModule} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {ContextComponent} from "./context/context.component";
import {ScaleComponent} from "./scale/scale.component";
import {RecipeList} from "./recipe-list/recipe-list";

const routes: Routes = [
  {path: '', redirectTo: '/login',pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path:'step_1', component: ContextComponent},
  {path:'scaleCategories', component: ScaleComponent},
  {path:'recipeList',component:RecipeList},
  {path: '**', redirectTo: '/login',pathMatch: 'full'}
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

