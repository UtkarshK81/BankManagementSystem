import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Transaction } from '../transaction';

@Component({
  selector: 'response',
  templateUrl: './response.component.html',
  styleUrls: ['./response.component.css']
})
export class ResponseComponent implements OnInit {
  public Id;
  public newWin;
  public transacs: Transaction[];

  constructor(private route:ActivatedRoute, private router:Router ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe( params => {
      this.Id=params.accountId;
      this.transacs = JSON.parse(params.transactions);
    });
  }

  
  backtopassbookmngt():void{
    this.router.navigateByUrl('/passbookManagement');
  }

  printRecord(): void{  
    var divToPrint = document.getElementById("transactionRecords");  
    this.newWin = window.open("");  
    this.newWin.document.write(divToPrint.outerHTML);  
    this.newWin.print();  
    this.newWin.close();  
}

}
