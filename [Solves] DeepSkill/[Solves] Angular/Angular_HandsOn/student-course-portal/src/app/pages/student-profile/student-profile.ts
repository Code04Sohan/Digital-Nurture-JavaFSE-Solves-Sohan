import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Course } from '../../models/course.model';
import { selectEnrolledCourses } from '../../store/enrollment/enrollment.selectors';

@Component({
  selector: 'app-student-profile',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="profile-container">
      <h2>My Enrolled Courses</h2>
      
      <!-- Using async inside ngIf to resolve the data safely -->
      <ng-container *ngIf="enrolledCourses$ | async as courses">
        <ul *ngIf="courses.length > 0; else noCourses">
          <li *ngFor="let course of courses">
            {{ course.name }} ({{ course.code }}) - {{ course.credits }} Credits
          </li>
        </ul>
      </ng-container>

      <ng-template #noCourses>
        <p>You are not enrolled in any courses yet.</p>
      </ng-template>
    </div>
  `
})
export class StudentProfileComponent {
  enrolledCourses$: Observable<Course[]>;

  constructor(private store: Store) {
    // Assign the selector inside the constructor after the store is injected
    this.enrolledCourses$ = this.store.select(selectEnrolledCourses);
  }
}