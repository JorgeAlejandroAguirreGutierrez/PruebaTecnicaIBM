import { Component, OnInit } from '@angular/core';
import { AdviserService } from './adviser.service';
import { Adviser } from './adviser';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-adviser',
  templateUrl: './adviser.component.html',
  styleUrls: ['./adviser.component.css']
})
export class AdviserComponent implements OnInit {

  cadviser= new Adviser();
  padviser= new Adviser();
  advisors: Adviser[];
  bandera: Boolean;

  constructor(private adviserService: AdviserService, private modalService: NgbModal) { }

  ngOnInit() {
    this.adviserService.get().subscribe(
      response=>this.advisors=response
    );
  }

  open(content: string, adviser: Adviser) {
    this.padviser=adviser;
    this.modalService.open(content, {size: 'lg'}).result.then((result) => {
      if (result=="update") {
        this.update(this.padviser);
      }
      if (result=="delete") {
        this.delete(this.padviser.id);
      }
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
    this.adviserService.create(this.cadviser).subscribe(
      res => {
        this.cadviser=res
        this.ngOnInit();
        Swal.fire('Mensaje', "Se ha creado el asesor", 'success');
      }
        ,
      err => Swal.fire('Error', err.error.mensaje, 'error')
    );
  }

  update(adviser: Adviser) {
    this.adviserService.update(adviser).subscribe(
      res => {
        this.padviser=res
        this.ngOnInit();
        Swal.fire('Mensaje', "Se ha actualizado el asesor", 'success');
      },
      err => Swal.fire('Error', err.error.mensaje, 'error')
    );
  }

  delete(id: number) {
    this.adviserService.delete(id).subscribe(
      res => {
        this.bandera=res
        this.ngOnInit();
        Swal.fire('Mensaje', "Se ha eliminado el asesor", 'success');
      },
      err => Swal.fire('Error', err.error.mensaje, 'error')
    );
  }

}
