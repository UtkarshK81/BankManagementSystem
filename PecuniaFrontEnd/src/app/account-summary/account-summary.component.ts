import { Component, OnInit } from '@angular/core';
import { PassbookService } from '../passbook.service'
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { Transaction } from '../transaction';

@Component({
  selector: 'app-account-summary',
  templateUrl: './account-summary.component.html',
  styleUrls: ['./account-summary.component.css'],
  providers: [DatePipe]
})
export class AccountSummaryComponent implements OnInit {
  transactions: Transaction[];
  transac: any;
  accountId: bigint;
  StartDate: Date;
  EndDate: Date;
  result: string;
  myDate = new Date();
  date:any;
  isValidDate: boolean;
  errorMsg: string;

  constructor(private service: PassbookService, private router: Router, private datePipe: DatePipe) {
    this.date = this.datePipe.transform(this.myDate, 'yyyy-MM-dd');
  }
                                                                                                                    

  ngOnInit(): void {
  }


  summary() {
    this.isValidDate = this.validateDates(this.StartDate, this.EndDate);
    if (this.isValidDate) {
      this.service.accountValidation(this.accountId).subscribe((data) => {
        this.result = data;
        if (this.result == "true") {
          this.service.accountSummary(this.accountId, this.StartDate, this.EndDate).subscribe((data) => {
            this.transac = data;
            this.transactions = this.transac;
            if (this.transac == 0) {
              alert("No Transactions Present!!");
            }
            else {
              this.router.navigate(['/response'], { queryParams: { accountId: this.accountId, transactions: JSON.stringify(this.transactions), } });
            }
          },(error)=>{
            this.errorMsg = error.error.message;
            console.log(error.error);
            alert(this.errorMsg);
          }
          );

        }
        // else {
        //   alert("No AccountId Present!!");
        // }
      },(error)=>{
        this.errorMsg = JSON.parse(error.error).message;
        console.log(error.error);
        alert(this.errorMsg);
      });

    }

  }
  validateDates(sDate: any, eDate: any): any {
    this.isValidDate = true;
    this.accountId=this.accountId;
    if ((sDate == null) || (eDate == null)||(this.accountId==null)) {
      this.isValidDate = false;
      alert("all fields are required");
    }
    else {
      if (((eDate) < (sDate))) {
        this.isValidDate = false;
        alert("End date should be greater then start date.")
      }
      else if (eDate > this.date) {
        alert("end date has exceeded todays date");
      }

      else {
        return this.isValidDate = true;
      }

    }

  }

  backtopassbookmngt():void{
    this.router.navigateByUrl('/passbookManagement');
  }
}