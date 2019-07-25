import { Injectable } from '@angular/core';
import { Adviser } from './adviser';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { map, catchError } from 'rxjs/operators';
import { of, Observable, throwError } from 'rxjs';
import { Router } from '@angular/router';
import * as global from '../global';

@Injectable({
  providedIn: 'root'
})
export class AdviserService {

  private headers= new HttpHeaders({'Content-Type':'application/json'});
  private options = {headers: this.headers};

  constructor(private http: HttpClient, private router: Router) { }

  create(adviser: Adviser): Observable<Adviser> {
    return this.http.post(global.endpoint+'/adviser', JSON.stringify(adviser), this.options).pipe(
      map(response => response as Adviser), 
      catchError(err => {
        return throwError(err);
        })
      );
  }

  get(): Observable<Adviser[]> {
    return this.http.get(global.endpoint+'/adviser').pipe(
      map(response => response as Adviser[]),
      catchError(err => {
        return throwError(err);
        })
      ); 
  }

  getID (id: number): Observable<Adviser> {
    return this.http.get<Adviser>(global.endpoint+'/adviser'+'/'+id).pipe(
      map(response => response as Adviser),
      catchError(err => {
        return throwError(err);
        })
      ); 
  }

  update(adviser: Adviser): Observable<Adviser> {
    return this.http.put(global.endpoint+'/adviser', JSON.stringify(adviser), this.options).pipe(
      map(response => response as Adviser), 
      catchError(err => {
        return throwError(err);
        })
      );
  }

  delete(id: number): Observable<boolean> {
    return this.http.delete(global.endpoint+'/adviser'+'/'+id).pipe(
      map(response => response as boolean), 
      catchError(err => {
        return throwError(err);
        })
      );
  }
}
