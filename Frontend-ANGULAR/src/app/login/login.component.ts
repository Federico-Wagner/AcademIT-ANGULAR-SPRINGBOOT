import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import { response } from "../Iresponse"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  msg:string = ""

  constructor(private router:Router, private http: HttpClient) { }

  ngOnInit(): void { }

  onSubmit(loginForm: NgForm) {
    this.http.post<Object>('http://localhost:9080/API/V1/login' , loginForm.value )
      .subscribe( res =>{
        let respons = res as response
        if (respons.meta.status) {
          this.router.navigate(["/", "user",`${respons.data.id}`])
        } else {
          this.msg = respons.error.message
        }
      })
  }
}
