import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { library } from '@fortawesome/fontawesome-svg-core';
import { fas } from '@fortawesome/free-solid-svg-icons';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';

import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './customer/customer.component';
import { HistoryComponent } from './history/history.component';
import { CustomerService} from './customer/customer.service';
import { HistoryService} from './history/history.service';
import { AdviserComponent } from './adviser/adviser.component';
import { AdviserService} from './adviser/adviser.service';

const routes: Routes = [
  {path: '', redirectTo: '/index', pathMatch: 'full'},
  {path: 'customer', component: CustomerComponent},
  {path: 'history', component: HistoryComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    CustomerComponent,
    HistoryComponent,
    AdviserComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    FontAwesomeModule,
    RouterModule.forRoot(routes)
  ],
  providers: [CustomerService, HistoryService, AdviserService],
  bootstrap: [AppComponent]
})
export class AppModule { 
  constructor() {
    // Add an icon to the library for convenient access in other components
    library.add(fas);
  }
}
