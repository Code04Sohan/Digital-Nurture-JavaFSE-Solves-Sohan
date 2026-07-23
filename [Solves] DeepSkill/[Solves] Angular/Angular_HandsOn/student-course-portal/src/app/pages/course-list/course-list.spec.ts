import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { CourseListComponent } from './course-list';

describe('CourseListComponent', () => {
  let component: CourseListComponent;
  let fixture: ComponentFixture<CourseListComponent>;
  let store: MockStore;

  const mockCourses = [
    { id: 1, name: 'Angular Basics', code: 'CS101', credits: 3, gradeStatus: 'passed' }
  ];

  // Configure the initial state for the selectors
  const initialState = {
    course: { courses: mockCourses, loading: false, error: null }
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseListComponent],
      providers: [provideMockStore({ initialState })]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseListComponent);
    component = fixture.componentInstance;
    store = TestBed.inject(MockStore);
    
    fixture.detectChanges(); // Trigger initial data binding
  });

  it('should render course cards based on the initial store state', () => {
    // Assert that exactly 1 card was rendered based on the mock state
    const cards = fixture.debugElement.queryAll(By.css('app-course-card'));
    expect(cards.length).toBe(1);
  });

  it('should show the loading indicator when state.loading is true', () => {
    // Force the mock store to update its state
    store.setState({ course: { courses: [], loading: true, error: null } });
    
    // Trigger change detection so the HTML updates
    fixture.detectChanges();

    const loadingElement = fixture.debugElement.query(By.css('p')).nativeElement;
    expect(loadingElement.textContent).toContain('Loading courses...');
  });
});