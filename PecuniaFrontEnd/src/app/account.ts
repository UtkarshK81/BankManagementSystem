import { Branch } from './branch';
import { Customer } from './customer';

export class Account {
    accountNumber:bigint;
    branch:Branch;
    accountType:string;
    accountBalance:number;
    lastUpdated:Date;
    customer:Customer;

    Account(accountNumber:bigint,branch:Branch,accountType:string,accountBalance:number,lastUpdated:Date,customer:Customer)
    {
        this.accountNumber=accountNumber;
        this.branch=branch;
        this.accountType=accountType;
        this.accountBalance=accountBalance;
        this.lastUpdated=lastUpdated;
        this.customer=customer;
    }
}
