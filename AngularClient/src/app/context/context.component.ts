import {Component, OnInit, Inject} from "@angular/core";
import {SESSION_STORAGE, WebStorageService} from 'angular-webstorage-service';
import {Router} from '@angular/router';


@Component({
  selector: 'context',
  templateUrl: './context.component.html',
  styleUrls: ['./context.component.css']
})
export class ContextComponent implements OnInit {

    warm: boolean;
    time: number;

  constructor(private router: Router, @Inject(SESSION_STORAGE) private storage: WebStorageService) {
  }

  ngOnInit() {
    this.warm=false;
    this.time=15;
    this.storage.set("warm",null);
    this.storage.set("time",null);

  }

  setMeal(meal){
    if(meal==="Frühstück")
    {
      this.warm=false;
    } else{
      this.warm=true;
    }
  }

  setTime(time){
    console.log("set time "+time);
    this.time=time;
  }

  submit(){
    console.log("submit "+this.time);
    this.storage.set("warm",this.warm);
    this.storage.set("time",this.time);
    this.router.navigate(['scaleCategories']);
  }
  startPage(){
    this.router.navigate(['login']);
  }

}
