import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UpdatePassbookComponent } from './update-passbook/update-passbook.component';
import { AccountSummaryComponent } from './account-summary/account-summary.component';
import { ResponseComponent } from './response/response.component';
import { AccountManagementComponent } from './account-management/account-management.component';
import { TransactionManagementComponent } from './transaction-management/transaction-management.component';
import { PassbookManagementComponent } from './passbook-management/passbook-management.component';
import { LoginManagementComponent } from './login-management/login-management.component';
import { AuthGuard } from './auth.guard';
import { AddAccountComponent } from './add-account/add-account.component';
import { DeleteAccountComponent } from './delete-account/delete-account.component';
import { SearchAccountComponent } from './search-account/search-account.component';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    UpdatePassbookComponent,
    AccountSummaryComponent,
    ResponseComponent,
    AccountManagementComponent,
    TransactionManagementComponent,
    PassbookManagementComponent,
    LoginManagementComponent,
    AddAccountComponent,
    DeleteAccountComponent,
    SearchAccountComponent,
    UpdateAccountComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot()
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
