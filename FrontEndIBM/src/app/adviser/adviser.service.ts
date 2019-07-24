import { Injectable } from '@angular/core';
import { Adviser } from './adviser';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { map, catchError } from 'rxjs/operators';
import { of, Observable, throwError } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AdviserService {

  private url: string ='http://localhost:8080/ibm/adviser';
  private headers= new HttpHeaders({'Content-Type':'application/json'});
  private options = {headers: this.headers};

  constructor(private http: HttpClient, private router: Router) { }

  create(adviser: Adviser): Observable<Adviser> {
    return this.http.post(this.url, JSON.stringify(adviser), this.options).pipe(
      map(response => response as Adviser), 
      catchError(err => {
        return throwError(err);
        })
      );
  }

  get(): Observable<Adviser[]> {
    return this.http.get(this.url).pipe(
      map(response => response as Adviser[]),
      catchError(err => {
        return throwError(err);
        })
      ); 
  }

  getID (id: number): Observable<Adviser> {
    return this.http.get<Adviser>(this.url+'/'+id).pipe(
      map(response => response as Adviser),
      catchError(err => {
        return throwError(err);
        })
      ); 
  }

  update(adviser: Adviser): Observable<Adviser> {
    return this.http.put(this.url, JSON.stringify(adviser), this.options).pipe(
      map(response => response as Adviser), 
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
