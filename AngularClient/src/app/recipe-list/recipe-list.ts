import {Component, OnInit, Inject} from "@angular/core";
import {SESSION_STORAGE, WebStorageService} from 'angular-webstorage-service';
import {Router} from '@angular/router';


@Component({
  selector: 'recipe-list',
  templateUrl: './recipe-list.html',
  styleUrls: ['./recipe-list.css']
})
export class RecipeList implements OnInit {

  constructor(private router: Router, @Inject(SESSION_STORAGE) private storage: WebStorageService) {
  }

  ngOnInit() {

  }

}
