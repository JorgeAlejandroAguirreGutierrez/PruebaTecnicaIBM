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

  ccustomer= new Customer();
  pcustomer= new Customer();
  customers: Customer[];
  bandera: Boolean;

  constructor(private customerService: CustomerService, private modalService: NgbModal) { }

  ngOnInit() {
    this.customerService.get().subscribe(
      response=>this.customers=response
    );
  }

  open(content: any, customer: Customer) {
    this.pcustomer=customer;
    this.modalService.open(content, {size: 'lg'}).result.then((result) => {
      if (result=="update") {
        this.update(this.pcustomer);
      }
      if (result=="delete") {
        this.delete(this.pcustomer.id);
      }
    }, (reason) => {

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
    this.customerService.create(this.ccustomer).subscribe(
      res => {
        this.ccustomer=res
        this.ngOnInit();
        Swal.fire('Mensaje', "Se ha creado el cliente", 'success');
      }
        ,
      err => Swal.fire('Error', err.error.mensaje, 'error')
    );
  }

  update(customer: Customer) {
    this.customerService.update(customer).subscribe(
      res => {
        this.pcustomer=res
        this.ngOnInit();
        Swal.fire('Mensaje', "Se ha actualizado el cliente", 'success');
      },
      err => Swal.fire('Error', err.error.mensaje, 'error')
    );
  }

  delete(id: number) {
    this.customerService.delete(id).subscribe(
      res => {
        this.bandera=res
        this.ngOnInit();
        Swal.fire('Mensaje', "Se ha eliminado el cliente", 'success');
      },
      err => Swal.fire('Error', err.error.mensaje, 'error')
    );
  }

}
