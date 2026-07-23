import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CourseService } from './course';
import { Course } from '../models/course.model';

describe('CourseService', () => {
  let service: CourseService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CourseService]
    });
    
    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    // Assert that no unexpected HTTP requests were made during the test
    httpMock.verify();
  });

  it('should fetch courses successfully', () => {
    const mockCourses: Course[] = [
      { id: 1, name: 'Angular Basics', code: 'CS101', credits: 3, gradeStatus: 'passed' },
      { id: 2, name: 'Advanced TS', code: 'CS201', credits: 4, gradeStatus: 'pending' }
    ];

    // 1. Subscribe to the method
    service.getCourses().subscribe(courses => {
      expect(courses.length).toBe(2);
      expect(courses).toEqual(mockCourses);
    });

    // 2. Expect a GET request to the specific URL
    const req = httpMock.expectOne('http://localhost:3000/courses');
    expect(req.request.method).toBe('GET');
    
    // 3. Flush (resolve) the request with the mock data
    req.flush(mockCourses);
  });

  it('should handle 500 server error correctly', () => {
    service.getCourses().subscribe({
      next: () => fail('Should have failed with a 500 error'),
      error: (error) => {
        expect(error.message).toContain('Failed to load courses');
      }
    });

    const req = httpMock.expectOne('http://localhost:3000/courses');
    
    // Flush the request with a server error
    req.flush('Server failed', { status: 500, statusText: 'Internal Server Error' });
  });
});