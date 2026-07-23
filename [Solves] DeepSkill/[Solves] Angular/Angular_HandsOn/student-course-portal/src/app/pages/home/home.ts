import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CourseService } from '../../services/course'; // <-- ADDED: Import the service

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './home.html', 
  styleUrl: './home.css'      
})
export class HomeComponent implements OnInit, OnDestroy {
  // Task 1 Properties
  portalName: string = 'Student Course Portal';
  isPortalActive: boolean = true;
  message: string = '';
  searchTerm: string = '';

  // <-- ADDED: Inject CourseService via constructor
  // Make it 'public' so it can be accessed directly in home.html
  constructor(public courseService: CourseService) {}

  // Task 1 Method
  onEnrollClick(): void {
    this.message = 'Enrollment opened!';
  }

  // Task 2 Lifecycle Hooks
  ngOnInit(): void {
    console.log('HomeComponent initialised — courses loaded');
  }

  ngOnDestroy(): void {
    console.log('HomeComponent destroyed');
  }
}