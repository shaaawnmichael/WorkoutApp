import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExerciseService } from '../exercise.service';
import { Exercise, Exercises, User } from '../models';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  exercise: Exercise[] = []
  exercises: Exercises[] = []
  id: any
  username!: User

  constructor(private exSvc : ExerciseService, private router: Router, private ActivatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.ActivatedRoute.snapshot.params['id']
    this.exSvc.getExercise(this.id)
       .then (e => {
        this.exercise = e
        console.log(typeof(e))
      })
      .catch(error => {
        alert('No exercise found with ID')
        this.back()
        console.error('>>> error:', error)
      })
      console.log('client exercises>>>', this.exercise);
  }

  back(): void {
    this.router.navigate(['/'])
  }

}
