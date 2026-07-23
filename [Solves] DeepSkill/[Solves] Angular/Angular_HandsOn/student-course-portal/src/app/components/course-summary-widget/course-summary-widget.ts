import { Component } from '@angular/core';
import { CourseService } from '../../services/course';

@Component({
  selector: 'app-course-summary-widget',
  standalone: true,
  template: `
    <div style="border: 1px solid #ccc; padding: 10px; margin-top: 20px;">
      <h4>Course Summary Widget</h4>
      <p>Total Courses in System: {{ courseService.getCourses().length }}</p>
      <button (click)="addTestCourse()">Add Test Course</button>
    </div>
  `
})
export class CourseSummaryWidgetComponent {
  constructor(public courseService: CourseService) {}

  addTestCourse() {
    this.courseService.addCourse({
      id: Math.random(),
      name: 'New Dynamic Course',
      code: 'TEST999',
      credits: 3,
      gradeStatus: 'pending'
    });
  }
}