import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExerciseService } from '../exercise.service';
import { Exercise, Exercises, User } from '../models';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  exercises: Exercises[] = []
  exercise: Exercise[] = []
  input: any
  //username!: User

  constructor( private exSvc: ExerciseService, private router: Router, private ActivatedRoute: ActivatedRoute) { }

  ngOnInit(): void {

    this.exSvc.getAllExercises()
      .then(result => this.exercises = result)
  }

  back(): void {
    this.router.navigate(['/'])
  }

/*   searchExercise(): void {
    this.exSvc.searchExercise(this.input)
      .subscribe({
        next: (data) => {
          this.exercises = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  } */

/*   processSearch() {
    const search: Exercises = this.search.value as Exercises
    console.info('>>>> reg: ', search)
    this.exSvc.searchExercise(this.input)
    console.info('>>>> input: ', this.exSvc.searchExercise(this.input))
  } */

/*   processSearch() {
    this.input = this.ActivatedRoute.snapshot.params['input']
    this.exSvc.searchExercise(this.input)
       .then (e => {
        this.exercises = e
        console.log(typeof(e))
        this.searchMapping();
      })
      .catch(error => {
        alert('No exercise found with search input')
        this.back()
        console.error('>>> error:', error)
      })
  } */

}
