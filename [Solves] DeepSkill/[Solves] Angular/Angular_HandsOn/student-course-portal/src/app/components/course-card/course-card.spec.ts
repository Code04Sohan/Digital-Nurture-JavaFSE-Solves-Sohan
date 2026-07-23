import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { SimpleChange } from '@angular/core';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { CourseCardComponent } from './course-card';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe'; // Adjust if filename differs

describe('CourseCardComponent', () => {
  let component: CourseCardComponent;
  let fixture: ComponentFixture<CourseCardComponent>;
  let store: MockStore;

  // Provide the initial state for the selectors to read
  const initialState = {
    enrollment: { enrolledCourseIds: [] }
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseCardComponent, CreditLabelPipe],
      providers: [provideMockStore({ initialState })]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseCardComponent);
    component = fixture.componentInstance;
    store = TestBed.inject(MockStore);

    // Mock the @Input property
    component.course = { 
      id: 1, 
      name: 'Data Structures', 
      code: 'CS101', 
      credits: 4, 
      gradeStatus: 'passed' 
    };
    
    // Trigger change detection to render the HTML
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should render course name and code via @Input', () => {
    // Query the DOM securely using By.css
    const h3Element = fixture.debugElement.query(By.css('h3')).nativeElement;
    expect(h3Element.textContent).toContain('Data Structures (CS101)');
  });

  it('should dispatch an action when the Enroll button is clicked', () => {
    // Spy on the NgRx store dispatch method (Replaces the @Output test)
    spyOn(store, 'dispatch');
    
    // Grab the second button (the enrollment toggle) and click it
    const buttons = fixture.debugElement.queryAll(By.css('button'));
    const enrollButton = buttons[1].nativeElement;
    enrollButton.click();
    
    expect(store.dispatch).toHaveBeenCalled();
  });

  it('should test ngOnChanges lifecycle hook (if implemented)', () => {
    spyOn(console, 'log');
    
    // Simulate Angular calling ngOnChanges
    if (component.ngOnChanges) {
      component.ngOnChanges({
        course: new SimpleChange(null, component.course, true)
      });
      expect(console.log).toHaveBeenCalled();
    }
  });
});