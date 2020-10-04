import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PassbookService {

  constructor(private httpService: HttpClient) { }
  updatePassbook(accountId:bigint){
    return this.httpService.get("http://localhost:9000/bank/updatePassbook/"+accountId ,{responseType: 'json'});
  }
  accountSummary(accountId:bigint,StartDate:Date,EndDate:Date){
    return this.httpService.get("http://localhost:9000/bank/accountSummary/"+accountId+"/"+StartDate+"/"+EndDate ,{responseType: 'json'});
  }
  accountValidation(accountId:bigint){
    return this.httpService.get("http://localhost:9000/bank/accountValidation/"+accountId ,{responseType: 'text'})
  }
}
