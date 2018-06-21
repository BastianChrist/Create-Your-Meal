import {Component, OnInit, Inject} from "@angular/core";
import {SESSION_STORAGE, WebStorageService} from 'angular-webstorage-service';
import {Router} from '@angular/router';


@Component({
  selector: 'context',
  templateUrl: './context.component.html',
  styleUrls: ['./context.component.css']
})
export class ContextComponent implements OnInit {

  constructor(private router: Router, @Inject(SESSION_STORAGE) private storage: WebStorageService) {
  }

  ngOnInit() {

  }

}
