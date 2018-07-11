import {Component, OnInit, Inject} from "@angular/core";
import {SESSION_STORAGE, WebStorageService} from 'angular-webstorage-service';
import {Router} from '@angular/router';
import * as Stomp from "@stomp/stompjs"
import * as SockJS from 'sockjs-client';
import {Scale} from "../domain/scale";
import {Context} from "../domain/context";
import {RecipeService} from "../service/recipe.service";
import {Recipe} from "../domain/recipe";
import {User} from "../domain/user";



@Component({
  selector: 'scale',
  templateUrl: './scale.component.html',
  styleUrls: ['./scale.component.css']
})
export class ScaleComponent implements OnInit {
  private serverUrl = 'http://localhost:8080/scale-websocket'
  private stompClient;
  private scale1:number;
  private scaleName1: string;
  private scale2:number;
  private scaleName2: string;

  private scale3:number;
  private scaleName3: string;

  private scale4:number;
  private scaleName4: string;

  private scale5:number;
  private scaleName5: string;

  private scale6:number;
  private scaleName6: string;

  user:User;




  constructor(private router: Router, @Inject(SESSION_STORAGE) private storage: WebStorageService, private recipeService: RecipeService) {
  }

  ngOnInit() {
    this.user= this.storage.get("user");


    this.initializeWebSocketConnection();
    this.storage.set("recipes",null);
    this.recipeService.getUserScaleAssignments(this.storage.get("userId")).then(userScaleAssignment => {
      this.scaleName1=userScaleAssignment[1];
      this.scaleName2=userScaleAssignment[2];
      this.scaleName3=userScaleAssignment[3];
      this.scaleName4=userScaleAssignment[4];
      this.scaleName5=userScaleAssignment[5];
      this.scaleName6=userScaleAssignment[6];
    });
  }
  initializeWebSocketConnection(){

    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
      console.log("connect to websocket");
      that.stompClient.subscribe("/weights", (message) => {
        console.log(message);
        var scaleList=JSON.parse(message.body);
        for(let entry of scaleList) {
          switch (entry.number) {
            case 1: {
              that.scale1 = entry.weight;
              break;
            }
            case 2: {
              that.scale2 = entry.weight;
              break;
            }
            case 3: {
              that.scale3 = entry.weight;
              break;
            }
            case 4: {
              that.scale4 = entry.weight;
              break;
            }
            case 5: {
              that.scale5 = entry.weight;
              break;
            }
            case 6: {
              that.scale6 = entry.weight;
              break;
            }
          }
        }

      });
      that.startScale();
    })
  }

  startScale(){
    this.stompClient.send("/startScale" , {}, {});
  }

  submit(){
    var type= this.storage.get("type");
    var warm= this.storage.get("warm");
    var time = this.storage.get("time");
    var userId =this.storage.get("userId");
    var type=this.storage.get("type");
    let scaleList = new Array();
    this.stompClient.disconnect();
    scaleList.push(new Scale(1,this.scale1));
    scaleList.push(new Scale(2,this.scale2));
    scaleList.push(new Scale(3,this.scale3));
    scaleList.push(new Scale(4,this.scale4));
    scaleList.push(new Scale(5,this.scale5));
    scaleList.push(new Scale(6,this.scale6));
    let context = new Context(time,warm,type,scaleList);
    this.recipeService.getRecipesForWeights(userId,context).then(recipes => {
      this.storage.set("recipes",recipes);
      this.router.navigate(['recipeList']);
    });

  }

  startPage(){
    this.router.navigate(['login']);
  }

  changeContext(){
    this.router.navigate(['step_1']);

  }

}
