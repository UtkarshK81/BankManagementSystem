import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';


@Component({
  selector: 'app-search-account',
  templateUrl: './search-account.component.html',
  styleUrls: ['./search-account.component.css']
})
export class SearchAccountComponent implements OnInit {

  
register :any;
  customer :any;
  address :any;
  accountNumber:number;
  


  constructor(private service:AccountService) { }


    public findAccountById()
    {
      let resp=this.service.getAccountById(this.accountNumber);
      resp.subscribe((data)=>this.register=[data]);

    }
  
  ngOnInit(){
    
   this.address=this.address;
   this.customer=this.customer;
     
    let resp=this.service.getAccounts();
    resp.subscribe((data)=>this.register=data);

  }

}