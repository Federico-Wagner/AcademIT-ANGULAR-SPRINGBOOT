import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { ClimateService } from "../climate.service"

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  weatherData: any;

  constructor(private clim: ClimateService, private http: HttpClient) { }

  ngOnInit(): void {
    this.clim.getClimateData().subscribe(res =>this.weatherData = res)
  }
}
