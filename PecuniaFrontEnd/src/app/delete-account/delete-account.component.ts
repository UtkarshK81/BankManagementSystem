import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-delete-account',
  templateUrl: './delete-account.component.html',
  styleUrls: ['./delete-account.component.css']
})
export class DeleteAccountComponent implements OnInit {

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
    public deleteAccount(accountNumber:number){
      let resp=this.service.deleteAccount(accountNumber);
      resp.subscribe((data)=>this.register=data);
    }
  

  ngOnInit(): void {
  }

}