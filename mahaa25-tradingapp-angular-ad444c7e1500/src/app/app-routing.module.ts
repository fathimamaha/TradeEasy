import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderComponent } from './order/order.component';
import { TraderCreateComponent } from './trader-create/trader-create.component';
import { TraderEditComponent } from './trader-edit/trader-edit.component';
import { TraderListComponent } from './trader-list/trader-list.component';
import { HomeComponent } from './home/home.component';
import { TradingHistoryComponent } from './trading-history/trading-history.component';
import { TeamComponent } from './team/team.component';
import { ConfirmsellComponent } from './confirmsell/confirmsell.component';
import { ConfirmbuyComponent } from './confirmbuy/confirmbuy.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'portfolio' },
  { path: 'portfolio', component: HomeComponent },
  { path: 'create-trader', component: TraderCreateComponent },
  { path: 'trader-list', component: TraderListComponent },
  { path: 'trader-edit/:id', component: TraderEditComponent }, 
  { path: 'order', component: OrderComponent },
  { path: 'trading-history', component: TradingHistoryComponent },
  { path: 'team', component: TeamComponent },
  { path: 'confirmsell/:id', component: ConfirmsellComponent },
  { path: 'confirmbuy/:id', component: ConfirmbuyComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
