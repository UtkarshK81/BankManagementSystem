import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class SignINService {

  constructor(private http:HttpClient) { }

  public loginUserFromRemote(employee:Employee):Observable<any>{

    return this.http.post<any>("http://localhost:9000/login",employee)
  }
}
