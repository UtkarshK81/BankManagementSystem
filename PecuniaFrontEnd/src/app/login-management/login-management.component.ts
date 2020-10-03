import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms'
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { SignINService } from '../sign-in.service';
@Component({
  selector: 'app-login-management',
  templateUrl: './login-management.component.html',
  styleUrls: ['./login-management.component.css']
})
export class LoginManagementComponent implements OnInit {
  employee=new Employee();
  message='';

  constructor(private service:SignINService, private router:Router) { }

  ngOnInit() {
  }

  loginUser(){
    this.service.loginUserFromRemote(this.employee).subscribe(
      data =>{ 
        console.log("Response Received");
        this.router.navigate(['/response']);

    },
      error =>{ 
        console.log("Exception Occured");
        this.message="Wrong EmailID and Password.Login Again";
      }
      
    )
  }
}
