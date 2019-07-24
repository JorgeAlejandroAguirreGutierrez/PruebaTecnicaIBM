import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';

import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './customer/customer.component';
import { CardComponent } from './card/card.component';
import { HistoryComponent } from './history/history.component';
import { CustomerService} from './customer/customer.service';
import { CardService} from './card/card.service';
import { HistoryService} from './history/history.service';

const routes: Routes = [
  {path: '', redirectTo: '/index', pathMatch: 'full'},
  {path: 'customer', component: CustomerComponent},
  {path: 'card', component: CardComponent},
  {path: 'history', component: HistoryComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    CustomerComponent,
    CardComponent,
    HistoryComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    RouterModule.forRoot(routes)
  ],
  providers: [CustomerService, CardService, HistoryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
