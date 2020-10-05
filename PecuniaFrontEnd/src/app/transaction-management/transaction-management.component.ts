import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, NumberValueAccessor, Validators } from '@angular/forms';
import { Cheque } from '../cheque';
import { NotificationService } from '../notification.service';

import { TransactionService } from '../transaction.service';

@Component({
  selector: 'app-transaction-management',
  templateUrl: './transaction-management.component.html',
  styleUrls: ['./transaction-management.component.css']
})
export class TransactionManagementComponent implements OnInit {

  cheque: Cheque;
  accountNumber:number;
  amount:number;
  chequeNumber:String;
  chequeAccountNumber:number;
  chequeHolderName:String;
  chequeBankName:String;
  chequeIfsc:String;
  chequeIssueDate:Date;
  chequeAmount:number;
  msg:String;
  errorMsg:String;
  constructor(private transactionService:TransactionService,private notify:NotificationService) { }

  ngOnInit(): void {
  }
 
  creditUsingCheque(){
    this.cheque=new Cheque();
    this.cheque.chequeBankName=this.chequeBankName;
    this.cheque.chequeHolderName=this.chequeHolderName;
    this.cheque.chequeIfsc=this.chequeIfsc;
    this.cheque.chequeNumber=this.chequeNumber;
    this.cheque.chequeIssueDate=this.chequeIssueDate;
    this.cheque.chequeAmount=this.chequeAmount;
    this.cheque.chequeAccountNumber=this.chequeAccountNumber;
    this.cheque.chequeStatus=null;
    console.log(this.cheque);
    this.transactionService.creditUsingCheque(this.cheque,this.accountNumber).subscribe(data=>{
      this.msg=JSON.stringify(data);
      console.log(this.msg);
      this.notify.showSuccess(this.msg,"Credit Using Cheque");
    },
    (error)=>{
      this.errorMsg=JSON.parse(error.error).message;
      console.log(error.error);
      this.notify.showError(this.errorMsg,"Credit Using Cheque");
    }
    )
  }

  debitUsingCheque(){
    this.cheque=new Cheque();
    this.cheque.chequeBankName=this.chequeBankName;
    this.cheque.chequeHolderName=this.chequeHolderName;
    this.cheque.chequeIfsc=this.chequeIfsc;
    this.cheque.chequeNumber=this.chequeNumber;
    this.cheque.chequeIssueDate=this.chequeIssueDate;
    this.cheque.chequeAmount=this.chequeAmount;
    this.cheque.chequeAccountNumber=this.chequeAccountNumber;
    this.cheque.chequeStatus=null;
    console.log(this.cheque);
    this.transactionService.debitUsingCheque(this.cheque,this.accountNumber).subscribe(data=>{
      this.msg=JSON.stringify(data);
      console.log(this.msg);
      this.notify.showSuccess(this.msg,"Debit Using Cheque");
    },
    (error)=>{
      this.errorMsg=JSON.parse(error.error).message;
      console.log(error.error);
      this.notify.showError(this.errorMsg,"Debit Using Cheque");
    })
  }
  debitUsingSlip() {
    this.transactionService.debitUsingSlip(this.accountNumber,this.amount).subscribe(data=>{
      this.msg=JSON.stringify(data);
      console.log(this.msg);
      this.notify.showSuccess(this.msg,"Debit Using Slip");
    },
    (error)=>{
      this.errorMsg=JSON.parse(error.error).message;
      console.log(error.error);
      this.notify.showError(this.errorMsg,"Debit Using Slip");
    })
  }
  creditUsingSlip(){
    this.transactionService.creditUsingSlip(this.accountNumber,this.amount).subscribe(data=>{
      this.msg=JSON.stringify(data);
      console.log(this.msg);
      this.notify.showSuccess(this.msg,"Credit Using Slip");
    },
    (error)=>{
      this.errorMsg=JSON.parse(error.error).message;
      console.log(error.error);
      this.notify.showError(this.errorMsg,"Credit Using Slip");
    })
  }
 
}