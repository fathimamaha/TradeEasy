import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TraderCreateComponent } from './trader-create/trader-create.component';
import { TraderEditComponent } from './trader-edit/trader-edit.component';
import { TraderListComponent } from './trader-list/trader-list.component';
import { HomeComponent } from './home/home.component';
import { OrderComponent } from './order/order.component';
import { TradingHistoryComponent } from './trading-history/trading-history.component';
import { TeamComponent } from './team/team.component';
import { ConfirmsellComponent } from './confirmsell/confirmsell.component';
import { ConfirmbuyComponent } from './confirmbuy/confirmbuy.component';



@NgModule({
  declarations: [
    AppComponent,
    TraderCreateComponent,
    TraderEditComponent,
    TraderListComponent,
    HomeComponent,
    OrderComponent,
    TradingHistoryComponent,
    TeamComponent,
    ConfirmsellComponent,
    ConfirmbuyComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
