import { Injectable } from '@angular/core';
import { Observable, forkJoin, of } from 'rxjs'; // <-- ADDED RxJS imports
import { CourseService } from './course';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {
  private enrolledCourseIds: number[] = [];

  constructor(private courseService: CourseService) {}

  enroll(courseId: number): void {
    if (!this.isEnrolled(courseId)) {
      this.enrolledCourseIds.push(courseId);
    }
  }

  unenroll(courseId: number): void {
    this.enrolledCourseIds = this.enrolledCourseIds.filter(id => id !== courseId);
  }

  isEnrolled(courseId: number): boolean {
    return this.enrolledCourseIds.includes(courseId);
  }

  // CHANGED: Now returns Observable<Course[]> and uses forkJoin
  getEnrolledCourses(): Observable<Course[]> {
    if (this.enrolledCourseIds.length === 0) {
      return of([]); // Return an empty observable array if not enrolled in anything
    }
    
    // Create an array of HTTP requests for each enrolled ID
    const courseRequests = this.enrolledCourseIds.map(id => this.courseService.getCourseById(id));
    
    // forkJoin fires them all off and waits for all of them to finish
    return forkJoin(courseRequests);
  }
}