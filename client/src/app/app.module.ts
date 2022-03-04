import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { ActivatedRoute, RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListComponent } from './components/list.component';
import { ExerciseService } from './exercise.service';
import { DetailComponent } from './components/detail.component';
import { SearchComponent } from './components/search.component';
import { AddToDatabaseComponent } from './components/add-to-database.component';
import { LoginComponent } from './UserComponents/login.component';
import { SignupComponent } from './UserComponents/signup.component';
import { ContactusComponent } from './components/contactus.component';


const appRoutes: Routes = [
	{ path: '', component: ListComponent },
  { path: 'exercise/:id', component: DetailComponent },
  { path: 'exercises/search/:input', component: SearchComponent },
  { path: 'addtodatabase', component: AddToDatabaseComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'contactus', component: ContactusComponent },
	{ path: '**', redirectTo: '/', pathMatch: 'full' }
]

@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    DetailComponent,
    SearchComponent,
    AddToDatabaseComponent,
    LoginComponent,
    SignupComponent,
    ContactusComponent,

  ],
  imports: [
    BrowserModule, FormsModule, ReactiveFormsModule,
    HttpClientModule, RouterModule.forRoot(appRoutes),
    AppRoutingModule,
    FormsModule, ReactiveFormsModule
  ],
  providers: [ExerciseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
