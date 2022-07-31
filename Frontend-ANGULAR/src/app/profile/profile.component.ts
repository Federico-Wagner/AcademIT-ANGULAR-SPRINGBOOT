import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";
import { response } from "../Iresponse"

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

          console.log(res)
          let response = res as response2
          // let que = response.data.transactions_received
          // let transactions = response.data.transactions_sent.concat(que)

          this.userData = response.data
          console.log(this.userData)
        })
    });
  }
}

interface response2 {
  "data": {
    "id": 1,
    "firstname": "Federico",
    "lastname": "Wagner",
    "email": "fedeWag@gmail.com",
    "password": "123456",
    "alias": "fede.mara.perro",
    "cbu": "123456789",
    "cta_$": 11532.48,
    "cta_u$$": 525.46,
    "transactions_sent": [
      {
        "type": {
          "currency": "Pesos"
        },
        "receptor": {
          "firstname": "Natalia",
          "lastname": "Garcia"
        },
        "amount": 500.0,
        "date": "2022-07-14 11:19:37"
      },
      {
        "type": {
          "currency": "Pesos"
        },
        "receptor": {
          "firstname": "Agustin",
          "lastname": "Martinez"
        },
        "amount": 300.0,
        "date": "2022-07-12 11:19:37"
      }
    ],
    "transactions_received": [
      {
        "type": {
          "currency": "Pesos"
        },
        "giver": {
          "firstname": "Natalia",
          "lastname": "Garcia"
        },
        "amount": 250.0,
        "date": "2022-07-13 11:22:01"
      }
    ]
  },
  "meta": {
    "copyright": "Copyright 2015 Example Corp.",
    "authors": "[Federico Wagner]",
    "status": true
  }
}
