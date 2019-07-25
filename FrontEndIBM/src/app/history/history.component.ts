import { Component, OnInit } from '@angular/core';
import { HistoryService } from './history.service';
import { CustomerService } from '../customer/customer.service';
import { CardService } from '../customer/card.service';
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
  card: Card;

  constructor(private customerService: CustomerService, private cardService: CardService, private modalService: NgbModal) { }

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
      }
    );
  }

  open(content: string, card: Card) {
    this.cardService.getHistorys(card.id).subscribe(
      response=>{
        this.card=response
        console.log(this.card);
      }
    );
    this.modalService.open(content, {size: 'lg'}).result.then((result) => {
    }, (reason) => {
      Swal.fire('Mensaje', `Dismissed ${this.getDismissReason(reason)}`, 'info');
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }
}
