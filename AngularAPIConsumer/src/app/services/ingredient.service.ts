import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  constructor(private httpClient:HttpClient) { }

  public getAllIngredient(): Observable<any> {
    return this.httpClient.get("http://localhost:8080/ingredient");
  }
}
