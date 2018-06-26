import {Component, OnInit, Inject} from "@angular/core";
import {LoginService} from "../service/login.service";
import {User} from "../domain/user";
import {SESSION_STORAGE, WebStorageService} from 'angular-webstorage-service';
import {Router} from '@angular/router';



@Component({
  selector: 'user-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  users: Array<User>;

  constructor(private router: Router, private loginService: LoginService, @Inject(SESSION_STORAGE) private storage: WebStorageService) {
  }

  ngOnInit() {
    this.loginService.getAll().then(users => {
      this.users=users;
    });
  }

  loginUser(user: User){
    this.storage.set("userId", user.id);
    this.router.navigate(['step_1']);
  }
}
