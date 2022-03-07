import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { lastValueFrom, Observable } from "rxjs";
import { Exercise, Exercises, Message, newUser, Profile, User } from "./models";


@Injectable()
  export class ExerciseService {
    constructor(private http: HttpClient) { }

    getAllExercises(offset=0, limit=1000): Promise<Exercises[]> {

      const params = new HttpParams().set("offset", offset).set("limit", limit)

      console.log(lastValueFrom(
        this.http.get<Exercises[]>('http://localhost:8080/api/exercises', { params })))

      return lastValueFrom(
        this.http.get<Exercises[]>('http://localhost:8080/api/exercises', { params })

      )
    }

    getExercise(eid: string): Promise<Exercise[]> {

      console.log("id>>>", eid)

      return lastValueFrom (
        this.http.get<Exercise[]>(`http://localhost:8080/api/exercise/${eid}`))
    }

    searchExercise(input: any): Observable<Exercise[]> {
      return this.http.get<Exercise[]>(`http://localhost:8080/api/exercises/search/${input}`);
    }

    saveExercise(exercise:any): Observable<any>{
      return this.http.post('http://localhost:8080/api/exercise/', exercise);
    }

    saveContactUsForm(contactus:any): Observable<any>{
      return this.http.post('http://localhost:8080/api/contactus', contactus);
    }

    signupUser(newUser:newUser){
      return this.http.post<any>(`http://localhost:8080/api/signup`,newUser)
    }

    userLogin(user: User){
      return this.http.post<any>(`http://localhost:8080/api/authenticate`, user);
    }

    getSecureProfile() {
      console.log("getting secure profile")
      return this.http.get<Profile[]>(`http://localhost:8080/api/profile`);
    }

   /*  getSecureProfile(username: any) {
      return this.http.get<Profile[]>(`http://localhost:8080/secure/api/profile/${username}`);
    } */

    /* searchExercise(input: string): Promise<Exercises[]> {

      console.log("search input>>>", input)

      return lastValueFrom (
        this.http.get<Exercises[]>(`http://localhost:8080/api/exercises/search/${input}`))


      } */

/*        console.log("get exercise", lastValueFrom (
        this.http.get<Exercises>('http://localhost:8080/api/exercise/'+eid)
      ).then (e => ({eid:e.eid,
                    body_part:e.body_part,
                    equipment:e.equipment,
                    gif_url:e.gif_url,
                    exercise_name:e.exercise_name,
                    exercise_target:e.exercise_target} as Exercises)))

      return lastValueFrom (
        this.http.get<Exercises>('http://localhost:8080/api/exercise/'+eid)
      ).then (e => ({eid:e.eid,
                    body_part:e.body_part,
                    equipment:e.equipment,
                    gif_url:e.gif_url,
                    exercise_name:e.exercise_name,
                    exercise_target:e.exercise_target} as Exercises))
    } */

/*     getExercise(eid: number): Promise<Exercises> {

      console.log("get exercise>>>",lastValueFrom (
        this.http.get<Exercises>('http://localhost:8080/api/exercise/'+1)))

      return lastValueFrom (
        this.http.get<Exercises>('http://localhost:8080/api/exercise/'+eid))
    } */



/*     getExercise(eid: number): Promise<Exercises> {
      return lastValueFrom (
        this.http.get<Exercises>('http://localhost:8080/api/exercise/'+eid)
      ).then (e => ({eid:e.eid,
                    body_part:e.body_part,
                    equipment:e.equipment,
                    gif_url:e.gif_url,
                    exercise_name:e.exercise_name,
                    exercise_target:e.exercise_target} as Exercises))
    } */

  }
