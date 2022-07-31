import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ClimateService {
  constructor(private http: HttpClient) { }

  getClimateData(): Observable<any>{
    return this.http.get('http://api.weatherapi.com/v1/current.json?key=83a8c4e295e04284a19132924222007&q=argentina&aqi=no');
  }
}
