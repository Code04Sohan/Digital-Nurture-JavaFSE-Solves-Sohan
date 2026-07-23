import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCardComponent } from '../../components/course-card/course-card';
import { HighlightDirective } from '../../directives/highlight';
import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent, HighlightDirective],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseListComponent implements OnInit {
  isLoading: boolean = true;
  courses: Course[] = [];

  // Inject the service via the constructor
  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    setTimeout(() => {
      this.isLoading = false;
      // Fetch live data from the service
      this.courses = this.courseService.getCourses(); 
    }, 1500);
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }
}