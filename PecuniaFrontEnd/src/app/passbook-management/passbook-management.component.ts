import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-passbook-management',
  templateUrl: './passbook-management.component.html',
  styleUrls: ['./passbook-management.component.css']
})
export class PassbookManagementComponent implements OnInit {

  constructor(private router:Router) { }

  updatePassbook():void{
    this.router.navigateByUrl('/updatePassbook');
  }

  accountSummary():void{
    this.router.navigateByUrl('/accountSummary');
  }

  ngOnInit(): void {
  }

}
