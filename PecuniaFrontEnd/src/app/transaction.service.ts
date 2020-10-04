import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import  {catchError,map,retry,tap} from 'rxjs/operators';
import { Cheque } from './cheque';
@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private baseUrl="http://localhost:9000/bank"
  constructor(private http:HttpClient) { }
 
  creditUsingSlip(accountNumber:number,amount:number):Observable<any>{
      return this.http.put(this.baseUrl+"/creditUsingSlip/"+accountNumber+"/"+amount,null,{responseType:'text'})
       
      
     }

  creditUsingCheque(cheque:Cheque,payeeAccountNumber:number):Observable<any>{
    return this.http.put(`${this.baseUrl}/creditUsingCheque/${payeeAccountNumber}`,cheque,{responseType:'text'})
     
  }
  
  debitUsingSlip(accountNumber:number,amount:number):Observable<any>{
    return this.http.put(`${this.baseUrl}/debitUsingSlip/${accountNumber}/${amount}`,null,{responseType:'text'})
  }

  debitUsingCheque(cheque:Cheque,payeeAccountNumber:number):Observable<any>{
    return this.http.put(`${this.baseUrl}/debitUsingCheque/${payeeAccountNumber}`,cheque,{responseType:'text'})
     
  }
  
 

}