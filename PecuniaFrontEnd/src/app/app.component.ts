import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SignINService } from './sign-in.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Pecunia-Passbook';

  constructor(private service: SignINService,private router: Router) { }

  logout(){
    this.service.isLoggedIn=false;
    this.router.navigateByUrl('/login');
  }
}
