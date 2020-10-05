import { Component, OnInit } from '@angular/core';
import { PassbookService } from '../passbook.service'
import { Router } from '@angular/router';
import { Transaction } from '../transaction';
import { NotificationService } from '../notification.service';
@Component({
  selector: 'app-update-passbook',
  templateUrl: './update-passbook.component.html',
  styleUrls: ['./update-passbook.component.css']
})
export class UpdatePassbookComponent implements OnInit {
  transactions: Transaction[];
  transac: any;
  accountId: bigint;
  message: string;
  errorMsg:string;
  result: string;
  constructor(private service: PassbookService, private router: Router,private notify:NotificationService) { }

  ngOnInit(): void {
  }
  update() {
    this.service.accountValidation(this.accountId).subscribe((data) => {
      this.result = data;
      console.log(this.result);
      if (this.result=="true") {
        this.service.updatePassbook(this.accountId).subscribe((data) => {
          this.transac = data;
          this.transactions = this.transac;
          console.log('transactions', this.transactions);
          
            this.router.navigate(['/response'], { queryParams: { accountId: this.accountId, transactions: JSON.stringify(this.transactions) } });
        },
        (error)=>{
          this.errorMsg = error.error.message;
          console.log(error.error);
          this.notify.showError(this.errorMsg,"Update Passbook");
        });
      }
    },(error)=>{
      this.errorMsg = JSON.parse(error.error).message;
      console.log(error.error);
      this.notify.showError(this.errorMsg,"Update Passbook");
    });
  }

  backtopassbookmngt():void{
    this.router.navigateByUrl('/passbookManagement');
  }
}

