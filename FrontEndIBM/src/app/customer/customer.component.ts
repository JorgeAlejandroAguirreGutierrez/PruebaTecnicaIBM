import { Component, OnInit } from '@angular/core';
import { CustomerService } from './customer.service';
import { Customer } from './customer';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customer= new Customer();
  customers: Customer[];
  bandera: Boolean;

  constructor(private customerService: CustomerService, private modalService: NgbModal) { }

  ngOnInit() {
    this.customerService.get().subscribe(
      response=>this.customers=response
    );
  }

  open(content: any) {
    this.modalService.open(content, {size: 'lg'}).result.then((result) => {
      Swal.fire('Mensaje', `Closed with: ${result}`, 'info');
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

  create() {
    this.customerService.create(this.customer).subscribe(
      res => this.customer=res,
      err => Swal.fire('Error', err.error.mensaje, 'error')
    );
  }

  update(customer: Customer) {
    this.customerService.update(customer).subscribe(
      res => this.customer=res,
      err => Swal.fire('Error', err.error.mensaje, 'error')
    );
  }

  delete(id: number) {
    this.customerService.delete(id).subscribe(
      res => this.bandera=res,
      err => Swal.fire('Error', err.error.mensaje, 'error')
    );
  }

}
