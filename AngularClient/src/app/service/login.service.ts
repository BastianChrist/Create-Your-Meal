/**
 * Created by schurli on 04.06.18.
 */
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from "../domain/user";
import {Recipe} from "../domain/recipe";
import {Observable} from "rxjs";


@Injectable()
export class LoginService {
  public API = '//localhost:8080';
  public USER_API = this.API + '/users';

  constructor(private http: HttpClient) {
  }

  getAll(): Promise<User[]> {

   return this.http.get(this.USER_API).toPromise().then( response => {
      var users = response as User[];
      return users;
  });
  }

  login(user:User):Observable<any>{

    return this.http.post(this.API + '/login', JSON.stringify(user));

  }


}
