import { Account } from './account';

export class Transaction {
    transId: bigint;
    transType:string;
    transAmount: number;
    transDate: Date;
    chequeNumber:string;
    account:Account;
  
    constructor(transId:number,transType:string,transAmount:number,transDate:Date,chequeNumber:string,account:Account){
      this.transId=this.transId;
      this.transType=transType;
      this.transAmount=transAmount;
      this.transDate=transDate;
      this.chequeNumber=chequeNumber;     
      this.account=account;
    }
  }