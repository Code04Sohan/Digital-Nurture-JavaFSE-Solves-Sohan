import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-detail',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div *ngIf="course" class="detail-card">
      <h2>{{ course.name }} ({{ course.code }})</h2>
      <p><strong>Credits:</strong> {{ course.credits }}</p>
      <p><strong>Status:</strong> {{ course.gradeStatus }}</p>
      <button (click)="goBack()">Back to Courses</button>
    </div>
    <div *ngIf="!course">
      <p>Course not found.</p>
    </div>
  `
})
export class CourseDetailComponent implements OnInit {
  course: Course | undefined;

  constructor(
    private route: ActivatedRoute, 
    private router: Router,
    private courseService: CourseService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    
    // CHANGED: Subscribe to the observable to get the actual course data
    this.courseService.getCourseById(id).subscribe({
      next: (courseData) => this.course = courseData,
      error: (err) => console.error('Error fetching course:', err)
    });
  }

  goBack(): void {
    this.router.navigate(['/courses']);
  }
}