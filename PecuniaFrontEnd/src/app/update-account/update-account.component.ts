import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';
import { Address } from '../address';
import { Customer } from '../customer';
import { Register } from '../register';

@Component({
  selector: 'app-update-account',
  templateUrl: './update-account.component.html',
  styleUrls: ['./update-account.component.css']
})
export class UpdateAccountComponent implements OnInit {


  register: Register=new Register();
  //customer :any;
  //address :any;
  accountNumber:number;
account:any;
  customer : Customer=new Customer();
  address : Address=new Address();
  
  constructor(private service:AccountService) { }


  public findAccountById()
    {
      let resp=this.service.getAccountById(this.accountNumber);
      resp.subscribe((data)=>{this.account=[data];
      this.register=this.account;})
      console.log(this.register);
      console.log(this.account);

    }
  
  ngOnInit(): void {
  }

}