import {Component, OnInit, Inject} from "@angular/core";
import {SESSION_STORAGE, WebStorageService} from 'angular-webstorage-service';
import {Router} from '@angular/router';


@Component({
  selector: 'scale',
  templateUrl: './scale.component.html',
  styleUrls: ['./scale.component.css']
})
export class ScaleComponent implements OnInit {

  constructor(private router: Router, @Inject(SESSION_STORAGE) private storage: WebStorageService) {
  }

  ngOnInit() {

  }

}
