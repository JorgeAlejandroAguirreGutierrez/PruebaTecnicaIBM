import { Injectable } from '@angular/core';
import { Card } from './card';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { map, catchError } from 'rxjs/operators';
import { of, Observable, throwError } from 'rxjs';
import { Router } from '@angular/router';
import * as global from '../global';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  private headers= new HttpHeaders({'Content-Type':'application/json'});
  private options = {headers: this.headers};
  
  constructor(private http: HttpClient, private router: Router) { }

  getHistorys (id: number): Observable<Card> {
    return this.http.get<Card>(global.endpoint+'/card/'+id+'/historys').pipe(
      map(response => response as Card),
      catchError(err => {
        return throwError(err);
        })
      ); 
  }
}
