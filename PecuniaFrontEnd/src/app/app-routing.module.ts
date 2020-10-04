import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UpdatePassbookComponent } from './update-passbook/update-passbook.component';
import { AccountSummaryComponent } from './account-summary/account-summary.component';
import { ResponseComponent } from './response/response.component';
import { AccountManagementComponent } from './account-management/account-management.component';
import { TransactionManagementComponent } from './transaction-management/transaction-management.component';
import { LoginManagementComponent } from './login-management/login-management.component';
import { PassbookManagementComponent } from './passbook-management/passbook-management.component';
import { AddAccountComponent } from './add-account/add-account.component';
import { SearchAccountComponent } from './search-account/search-account.component';
import { DeleteAccountComponent } from './delete-account/delete-account.component';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [
  {path:'updatePassbook',component:UpdatePassbookComponent, canActivate:[AuthGuard]},
  {path:'accountSummary',component:AccountSummaryComponent, canActivate:[AuthGuard]},
  {path:'response',component:ResponseComponent, canActivate:[AuthGuard]},
  {path:'accountManagement',component:AccountManagementComponent, canActivate:[AuthGuard]},
  {path:'transactionManagement',component:TransactionManagementComponent, canActivate:[AuthGuard]},
  {path:'passbookManagement',component:PassbookManagementComponent, canActivate:[AuthGuard]},
  {path:'login',component:LoginManagementComponent},
  {path:'addAccount',component:AddAccountComponent, canActivate:[AuthGuard]},
  {path:'searchAccount',component:SearchAccountComponent, canActivate:[AuthGuard]},
  {path:'deleteAccount',component:DeleteAccountComponent, canActivate:[AuthGuard]},
  {path:'updateAccount',component:UpdateAccountComponent, canActivate:[AuthGuard]},



  {path:'', redirectTo: '/login', pathMatch:'full'}       
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
