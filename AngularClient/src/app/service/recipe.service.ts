import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Recipe} from "../domain/recipe";
import {Context} from "../domain/context";
import { HttpHeaders } from '@angular/common/http';

import {Observable} from "rxjs";

@Injectable()
export class RecipeService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) {
  }

  getRecipesForWeights(userId: string, context:Context): Promise<Recipe[]> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    };
    var recipeCall= this.API+"/users/"+userId+"/recipes";
    return this.http.post(recipeCall,context,httpOptions).toPromise().then(response => {
      console.log(response);
      var recipes = response as Recipe[];
      return recipes;
    });
  }

  getUserScaleAssignments(userId:string){
    var userAssignmentCall= this.API+"/users/"+userId+"/userscales";
    return this.http.get(userAssignmentCall).toPromise().then(response => {
      return response as Map<string,string>;
    })
  }
}
