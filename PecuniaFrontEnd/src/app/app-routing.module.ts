import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccountManagementComponent } from './account-management/account-management.component';
import { AccountSummaryComponent } from './account-summary/account-summary.component';
import { LoginManagementComponent } from './login-management/login-management.component';
import { PassbookManagementComponent } from './passbook-management/passbook-management.component';
import { ResponseComponent } from './response/response.component';
import { TransactionManagementComponent } from './transaction-management/transaction-management.component';
import { UpdatePassbookComponent } from './update-passbook/update-passbook.component';

const routes: Routes = [
    {path:'updatePassbook',component:UpdatePassbookComponent},
  {path:'acocuntSummary',component:AccountSummaryComponent},
  {path:'response',component:ResponseComponent},
  {path:'accountManagement',component:AccountManagementComponent},
  {path:'transactionManagement',component:TransactionManagementComponent},
  {path:'passbookManagement',component:PassbookManagementComponent},
  {path:'login',component:LoginManagementComponent},


  {path:'', redirectTo: '/login', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
