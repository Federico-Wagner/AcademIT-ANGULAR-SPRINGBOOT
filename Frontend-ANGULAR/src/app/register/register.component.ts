import { Component, OnInit } from '@angular/core';
//import { FormGroup, FormControl } from '@angular/forms';
import {AbstractControl, FormBuilder, ValidationErrors, ValidatorFn} from '@angular/forms';
import { Validators } from '@angular/forms';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import { response } from "../Iresponse"

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  msg:string=""

  registerForm = this.fb.group({
    firstName: ['', [Validators.minLength(3), Validators.maxLength(30)]],
    lastName: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]],
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required]],
    passwordRepeat: ['', [Validators.required]]
    },
  );

  // registerForm = new FormGroup({
  //   firstName: new FormControl(''),
  //   lastName: new FormControl(''),
  //   email: new FormControl(''),
  //   password: new FormControl(''),
  //   passwordRepeat: new FormControl('')
  // })

  constructor(private fb: FormBuilder, private router:Router, private http: HttpClient) { }
  ngOnInit(): void {
  }

  onSubmit() {
    this.http.post('http://localhost:9080/API/V1/register', this.registerForm.value)//'{"email": "f@gmail.com","password": "1234"}'
      .subscribe(res => {
        let response = res as response
        if (response.meta.status) {
          this.router.navigate(["/", "login"])
        } else {
          this.msg = response.error.message
        }
      })
  }
}
