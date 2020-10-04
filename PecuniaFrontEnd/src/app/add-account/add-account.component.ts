import { Component, OnInit } from '@angular/core';

import { AccountService } from '../account.service';
import { Address } from '../address';
import { Customer } from '../customer';

import { Register } from '../register';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.css']
})
export class AddAccountComponent implements OnInit {

  register = new Register();
  customer =new Customer();
  address =new Address();
 

  constructor(private service:AccountService) { }

  ngOnInit(){

  }

  accountDetails(){
      this.customer.address=this.address;
      this.register.customer=this.customer;
      this.service.addAccount(this.register).subscribe(
        data=>{console.log("request send");},
        error=>{console.log("failure");}

      )
  }
}