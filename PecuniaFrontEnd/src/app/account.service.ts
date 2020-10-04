import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Register } from './register';


@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http:HttpClient) { }

  public addAccount(register:Register){
    return this.http.post("http://localhost:9000/bank/addAccount",register,{responseType:'text' as 'json'});
  }
  public getAccounts(){
    return this.http.get("http://localhost:9000/bank/accounts");
  }
  public getAccountById(accountNumber){
    return this.http.get("http://localhost:9000/bank/accounts/"+accountNumber);
  }
  public deleteAccount(accountNumber){
    return this.http.delete("http://localhost:9000/bank/delete/"+accountNumber);
  }
  public updateAccount(accountNumber:number){
    return this.http.put("http://localhost:9000/bank/updateAccount",accountNumber);
  }
}