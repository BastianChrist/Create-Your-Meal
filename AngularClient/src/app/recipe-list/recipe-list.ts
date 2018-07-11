import {Component, OnInit, Inject} from "@angular/core";
import {SESSION_STORAGE, WebStorageService} from 'angular-webstorage-service';
import {Router} from '@angular/router';
import {Recipe} from "../domain/recipe";
import {User} from "../domain/user";


@Component({
  selector: 'recipe-list',
  templateUrl: './recipe-list.html',
  styleUrls: ['./recipe-list.css']
})
export class RecipeList implements OnInit {

  private recipes:Array<Recipe>;
  user:User;
  constructor(private router: Router, @Inject(SESSION_STORAGE) private storage: WebStorageService) {
  }

  ngOnInit() {
    this.recipes=this.storage.get("recipes");
    this.user= this.storage.get("user");

    this.recipes.length=3;
  }

  startPage(){
    this.router.navigate(['login']);
  }

  again(){
    this.router.navigate(['scaleCategories']);
  }

}
