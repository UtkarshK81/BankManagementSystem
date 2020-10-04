import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-account-management',
  templateUrl: './account-management.component.html',
  styleUrls: ['./account-management.component.css']
})
export class AccountManagementComponent implements OnInit {

  constructor(private router:Router) { }
addAccount():void{
  this.router.navigateByUrl('/addAccount');
}
searchAccount():void{
  this.router.navigateByUrl('/searchAccount');
}

  ngOnInit(): void {
  }

}