import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ExerciseService } from '../exercise.service';
import { ExerciseAdd, Exercises, Message } from '../models';

@Component({
  selector: 'app-add-to-database',
  templateUrl: './add-to-database.component.html',
  styleUrls: ['./add-to-database.component.css']
})
export class AddToDatabaseComponent implements OnInit {

  form!:FormGroup
  exercises!: Exercises
  message!: Message

  constructor(private fb: FormBuilder, private exSvc : ExerciseService, private route: Router) { }

  ngOnInit(): void {
    this.form=this.createForm()
  }

  processForm() {
    const ea = this.form.value as ExerciseAdd
    console.log(ea)
    this.exSvc.saveExercise(ea).subscribe(response =>
      console.log(response))

  }

  private createForm(): FormGroup {
    return this.fb.group({
      body_part: this.fb.control('', [ Validators.required, Validators.minLength(3) ]),
      equipment: this.fb.control('', [ Validators.required, Validators.minLength(3) ]),
      gif_url: this.fb.control('', [ Validators.required, Validators.minLength(3) ]),
      exercise_name: this.fb.control('', [ Validators.required, Validators.minLength(3)]),
      exercise_target: this.fb.control('', [ Validators.required, Validators.minLength(3)]),
    })
  }

}
