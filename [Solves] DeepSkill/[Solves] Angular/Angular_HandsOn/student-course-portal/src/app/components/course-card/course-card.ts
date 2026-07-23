import { Component, Input, OnInit, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { map, take } from 'rxjs/operators';
import { Course } from '../../models/course.model';
import { enrollInCourse, unenrollFromCourse } from '../../store/enrollment/enrollment.actions';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe'; 

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, CreditLabelPipe],
  templateUrl: './course-card.html'
})
// ADDED: implements OnChanges
export class CourseCardComponent implements OnInit, OnChanges {
  @Input() course!: Course;
  isExpanded: boolean = false;
  
  enrolledIds$!: Observable<number[]>;
  isEnrolled$!: Observable<boolean>;

  constructor(private store: Store) {}

  ngOnInit(): void {
    this.enrolledIds$ = this.store.select(selectEnrolledIds);
    this.isEnrolled$ = this.enrolledIds$.pipe(
      map(ids => ids.includes(this.course.id))
    );
  }

  // ADDED: The ngOnChanges lifecycle hook
  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log('Course input changed!', changes);
    }
  }

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }

  toggleEnrollment(): void {
    this.isEnrolled$.pipe(take(1)).subscribe(currentlyEnrolled => {
      if (currentlyEnrolled) {
        this.store.dispatch(unenrollFromCourse({ courseId: this.course.id }));
      } else {
        this.store.dispatch(enrollInCourse({ courseId: this.course.id }));
      }
    });
  }
}