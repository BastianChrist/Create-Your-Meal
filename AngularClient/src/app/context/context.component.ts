import {Component, OnInit, Inject} from "@angular/core";
import {SESSION_STORAGE, WebStorageService} from 'angular-webstorage-service';
import {Router} from '@angular/router';
import {User} from "../domain/user";


@Component({
  selector: 'context',
  templateUrl: './context.component.html',
  styleUrls: ['./context.component.css']
})
export class ContextComponent implements OnInit {

    warm: boolean;
    time: number;
    type:string;
    user: User;

  constructor(private router: Router, @Inject(SESSION_STORAGE) private storage: WebStorageService) {
  }

  ngOnInit() {
    this.type="Frühstück";
    this.time=15;
    this.user= this.storage.get("user");
    this.storage.set("warm",null);
    this.storage.set("time",null);

  }

  setMeal(type){
    this.type=type;
  }

  setTime(time){
    console.log("set time "+time);
    this.time=time;
  }
  setWarm(warm){
    this.warm=warm;
  }

  submit(){
    console.log("submit "+this.time);
    this.storage.set("type",this.type);
    this.storage.set("warm",this.warm);
    this.storage.set("time",this.time);
    this.router.navigate(['scaleCategories']);
  }
  startPage(){
    this.router.navigate(['login']);
  }

}
