import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms'
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { NotificationService } from '../notification.service';
import { SignINService } from '../sign-in.service';
@Component({
  selector: 'app-login-management',
  templateUrl: './login-management.component.html',
  styleUrls: ['./login-management.component.css']
})
export class LoginManagementComponent implements OnInit {
  employee=new Employee();
  message='';

  constructor(private service:SignINService, private router:Router,private notifyService : NotificationService) { }

  ngOnInit() {
  }

  loginUser(){
    this.service.loginUserFromRemote(this.employee).subscribe(
      data =>{ 
        console.log("Response Received");
        this.router.navigateByUrl('/accountManagement');
        this.service.isLoggedIn=true;

    },
      error =>{ 
        console.log("Wrong Details");
        this.notifyService.showError("Wrong EmailID and Password Login Again","LogIn Error");
      }
      
    )
  }
}