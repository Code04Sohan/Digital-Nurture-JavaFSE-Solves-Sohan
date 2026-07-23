import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // <-- ADDED
import { CourseService } from '../../services/course';

@Component({
  selector: 'app-course-summary-widget',
  standalone: true,
  imports: [CommonModule], // <-- ADDED
  template: `
    <div style="border: 1px solid #ccc; padding: 10px; margin-top: 20px;">
      <h4>Course Summary Widget</h4>
      <!-- ADDED async pipe and safe navigation (?) -->
      <p>Total Courses in System: {{ (courseService.getCourses() | async)?.length || 0 }}</p>
      <button (click)="addTestCourse()">Add Test Course</button>
    </div>
  `
})
export class CourseSummaryWidgetComponent {
  constructor(public courseService: CourseService) {}

  addTestCourse() {
    // CHANGED: addCourse is now createCourse, and we must subscribe() to trigger the HTTP POST
    this.courseService.createCourse({
      name: 'New Dynamic Course',
      code: 'TEST999',
      credits: 3,
      gradeStatus: 'pending'
    }).subscribe(); 
  }
}