import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ExerciseService } from '../exercise.service';
import { ContactUs, User } from '../models';

@Component({
  selector: 'app-contactus',
  templateUrl: './contactus.component.html',
  styleUrls: ['./contactus.component.css']
})
export class ContactusComponent implements OnInit {

  form!:FormGroup
  username!: User


  constructor(private fb: FormBuilder, private exSvc : ExerciseService, private route: Router) { }

  ngOnInit(): void {
    this.form=this.createForm()
  }

  processForm() {
    const cs = this.form.value as ContactUs
    console.log(cs)
    this.exSvc.saveContactUsForm(cs).subscribe(response =>
      console.log(response))

  }

  private createForm(): FormGroup {
    return this.fb.group({
      email: this.fb.control('', [ Validators.email, Validators.required, Validators.minLength(5) ]),
      subject: this.fb.control('', [ Validators.required, Validators.minLength(3) ]),
      enquiry: this.fb.control('', [ Validators.required, Validators.minLength(3) ]),
    })
  }

}

