import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InovoiceListComponent } from './components/inovoice-list/inovoice-list.component';
import { WelcomeComponent } from './components/welcome/welcome.component';

const routes: Routes = [
	  { path: '', redirectTo: 'welcome', pathMatch: 'full' },
	  { path: 'welcome', component: WelcomeComponent },
	  { path: 'view-inovoice', component: InovoiceListComponent }
	];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
