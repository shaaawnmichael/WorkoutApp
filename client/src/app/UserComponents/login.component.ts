import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError } from 'rxjs';
import { ExerciseService } from '../exercise.service';
import { User } from '../models';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm! : FormGroup;
  username!: User

  constructor(private fb: FormBuilder, private exerciseSvc:ExerciseService, private tokenSvc: TokenStorageService, private router: Router) { } //

  ngOnInit(): void {
    this.createForm();
  }

  createForm() {
    this.loginForm = this.fb.group({
      username: this.fb.control('',[Validators.required, Validators.minLength(3)]),
      password: this.fb.control('',[Validators.required])
    })
  }

  login(){
    const credentials = this.loginForm.value as User

    this.exerciseSvc.userLogin(credentials)
      .pipe(catchError(async (err) => alert('Account not registered or password is invalid. Please try again.')))
      .subscribe(response => {
        console.log(response)
        this.tokenSvc.saveToken(response['token'])
        this.tokenSvc.saveUser(response['subject'])
        this.router.navigate(["/profile"])
        //this.router.navigate(["/profile", this.loginForm.get("username")?.value]);
      })


  }

}
