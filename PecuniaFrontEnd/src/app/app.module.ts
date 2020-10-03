import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountManagementComponent } from './account-management/account-management.component';
import { AccountSummaryComponent } from './account-summary/account-summary.component';
import { LoginManagementComponent } from './login-management/login-management.component';
import { PassbookManagementComponent } from './passbook-management/passbook-management.component';
import { ResponseComponent } from './response/response.component';
import { TransactionManagementComponent } from './transaction-management/transaction-management.component';
import { UpdatePassbookComponent } from './update-passbook/update-passbook.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    AccountManagementComponent,
    AccountSummaryComponent,
    LoginManagementComponent,
    PassbookManagementComponent,
    ResponseComponent,
    TransactionManagementComponent,
    UpdatePassbookComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
