import { Injectable } from '@angular/core';
import { Customer } from './customer';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { map, catchError } from 'rxjs/operators';
import { of, Observable, throwError } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private url: string ='http://localhost:8000/ibm/customer';
  private headers= new HttpHeaders({'Content-Type':'application/json'});
  private options = {headers: this.headers};
  
  constructor(private http: HttpClient, private router: Router) { }

  create(customer: Customer): Observable<Customer> {
    return this.http.post(this.url+'create', JSON.stringify(customer), this.options).pipe(
      map(response => response as Customer), 
      catchError(err => {
        return throwError(err);
        })
      );
  }

  get(): Observable<Customer[]> {
    return this.http.get(this.url).pipe(
      map(response => response as Customer[]),
      catchError(err => {
        return throwError(err);
        })
      ); 
  }

  getID (id: number): Observable<Customer> {
    return this.http.get<Customer>(this.url+'/'+id).pipe(
      map(response => response as Customer),
      catchError(err => {
        return throwError(err);
        })
      ); 
  }

  update(customer: Customer): Observable<Customer> {
    return this.http.put(this.url, JSON.stringify(customer), this.options).pipe(
      map(response => response as Customer), 
      catchError(err => {
        return throwError(err);
        })
      );
  }

  delete(id: number): Observable<boolean> {
    return this.http.delete(this.url+'/'+id).pipe(
      map(response => response as boolean), 
      catchError(err => {
        return throwError(err);
        })
      );
  }
}
