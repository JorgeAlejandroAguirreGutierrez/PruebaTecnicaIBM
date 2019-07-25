import { Component, OnInit } from '@angular/core';
import { HistoryService } from './history.service';
import { CustomerService } from '../customer/customer.service';
import { History } from './history';
import { Customer } from '../customer/customer';
import { Card } from '../customer/card';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  customers: Customer[];
  scustomer= new Customer();
  cards= [];

  constructor(private customerService: CustomerService, private historyService: HistoryService, private modalService: NgbModal) { }

  ngOnInit() {
    this.customerService.get().subscribe(
      response=>{
        this.customers=response
        console.log(this.customers);
      }
    );
  }

  select(id: number) {
    this.customerService.getCards(id).subscribe(
      response=>{
        this.scustomer=response
        console.log(this.scustomer.name);
      }
    );
  }
}
