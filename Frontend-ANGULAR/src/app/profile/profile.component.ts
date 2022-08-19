import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  userData : any

  constructor(private http: HttpClient, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(s => {
      this.http.get<Object>(`http://localhost:9080/user/${s["id"]}`)
        .subscribe( res =>{
          let response = res as responseStructure
          this.userData = response.data
          //console.log(this.userData)
        })
    });
  }
}

interface responseStructure {
  "data": {
    "id": 1,
    "firstname": "",
    "lastname": "",
    "email": "",
    "password": "",
    "alias": "",
    "cbu": "",
    "cta_$": 0,
    "cta_u$$": 0,
    "transactions_sent": [
      {
        "type": {
          "currency": ""
        },
        "receptor": {
          "firstname": "",
          "lastname": ""
        },
        "amount": 0,
        "date": ""
      }
    ],
    "transactions_received": [
      {
        "type": {
          "currency": ""
        },
        "giver": {
          "firstname": "",
          "lastname": ""
        },
        "amount": 0,
        "date": ""
      }
    ]
  },
  "meta": {
    "copyright": "",
    "authors": "",
    "status": true
  }
}
