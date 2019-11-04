import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NewCourse } from '../models/newCourse';
import { NewRate } from '../models/newRate';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http: HttpClient) { }

  addCourse(course: NewCourse) {
    return this.http.post(`${environment.gatewayurl}/course/api/v1/addcourse`, course);
  }


  addRate(rate: NewRate) {
    return this.http.post(`${environment.gatewayurl}/course/api/v1/addrate`, rate);
  }

  findCourses() {
    return this.http.get(`${environment.gatewayurl}/search/api/search/course/list`);
  }

  searchCourses() {
    return this.http.get(`${environment.gatewayurl}/training/api/training/enable/list`);
  }


  bookCourses(id: number, username: string, mentorname: string) {
    return this.http.get(`${environment.gatewayurl}/course/api/v1/mentor/book?id=${id}&username=${username}&mentorname=${mentorname}`);
  }

  findUserCourses(tabIndex: number, username: string) {
    if(tabIndex == 2){
        return this.http.get(`${environment.gatewayurl}/training/api/training/my/list/completed/${username}`);
    }else{
        return this.http.get(`${environment.gatewayurl}/training/api/training/my/list/going/${username}`);
    }
  }

}
