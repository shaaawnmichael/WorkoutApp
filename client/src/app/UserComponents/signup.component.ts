import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError } from 'rxjs';
import { ExerciseService } from '../exercise.service';
import { newUser, User } from '../models';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupForm! : FormGroup
  username!: User

  constructor(private fb: FormBuilder, private exerciseSvc:ExerciseService, private router:Router) { }

  ngOnInit(): void {
    this.createform();
  }

  createform() {
    this.signupForm = this.fb.group({
    username: this.fb.control('',[Validators.required, Validators.minLength(3)]),
    password: this.fb.control('',[Validators.required, Validators.minLength(3)])
    })
  }

  signup(){
    const newUser = this.signupForm.value as newUser;
    this.exerciseSvc.signupUser(newUser)
      .pipe(catchError(async (err) => alert('Username already in use. Please choose a different username.')))
      .subscribe(response=> {
        console.log(response)
      })
    this.router.navigate(['/']).then(r => alert('Account created!'))
  }

}
