import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError, tap, retry } from 'rxjs/operators';
import { Course } from '../models/course.model';

@Injectable({ providedIn: 'root' })
export class CourseService {
  private apiUrl = 'http://localhost:3000/courses';

  constructor(private http: HttpClient) {}

  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(this.apiUrl).pipe(
      // Retry strategy: attempt 2 extra times before failing
      retry(2),
      
      /* 
        CODE COMMENT EXPLANATION: tap vs map
        'tap' is used strictly for side-effects (like logging or debugging) and does not alter the data stream.
        'map' is used to transform the data structure before passing it to the subscriber.
      */
      tap(courses => console.log(`Courses loaded: ${courses.length}`)),
      
      // Transform response to only include courses with valid credits
      map(courses => courses.filter(c => c.credits > 0)),
      
      // Error handling trap
      catchError(err => {
        console.error('Service caught an error:', err);
        return throwError(() => new Error('Failed to load courses. Please try again.'));
      })
    );
  }

  getCourseById(id: number): Observable<Course> {
    return this.http.get<Course>(`${this.apiUrl}/${id}`);
  }

  createCourse(course: Omit<Course, 'id'>): Observable<Course> {
    return this.http.post<Course>(this.apiUrl, course);
  }

  updateCourse(course: Course): Observable<Course> {
    return this.http.put<Course>(`${this.apiUrl}/${course.id}`, course);
  }

  deleteCourse(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}