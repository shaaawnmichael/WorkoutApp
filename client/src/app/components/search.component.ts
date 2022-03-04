import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExerciseService } from '../exercise.service';
import { Exercise, Exercises } from '../models';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  input: any
  exercise: Exercise[] = []
  exercises: Exercises[] = []
  id: any
  e = !null;

  constructor(private exSvc: ExerciseService, private router: Router, private ActivatedRoute: ActivatedRoute) { }

  ngOnInit(): void {

    this.exSvc.getAllExercises()
    .then(result => this.exercises = result)

    this.input = this.ActivatedRoute.snapshot.params['input']
    this.exSvc.searchExercise(this.input)
    .subscribe({
      next: (data) => {
        this.exercise = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });

  }

  back(): void {
    this.router.navigate(['/'])
  }

}
