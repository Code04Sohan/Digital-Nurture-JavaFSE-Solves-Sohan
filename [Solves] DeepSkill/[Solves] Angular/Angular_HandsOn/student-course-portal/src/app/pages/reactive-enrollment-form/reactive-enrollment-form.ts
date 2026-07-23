import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, FormArray, Validators, AbstractControl, ValidationErrors } from '@angular/forms';

// --- Custom Synchronous Validator ---
export function noCourseCode(control: AbstractControl): ValidationErrors | null {
  const value = control.value;
  if (value && typeof value === 'string' && value.toUpperCase().startsWith('XX')) {
    return { noCourseCode: true };
  }
  return null;
}

// --- Custom Asynchronous Validator ---
export function simulateEmailCheck(control: AbstractControl): Promise<ValidationErrors | null> {
  return new Promise(resolve => {
    setTimeout(() => {
      if (control.value && control.value.includes('test@')) {
        resolve({ emailTaken: true });
      } else {
        resolve(null);
      }
    }, 800);
  });
}

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule], // Note: ReactiveFormsModule instead of FormsModule
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css'
})
export class ReactiveEnrollmentFormComponent implements OnInit {
  enrollForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.enrollForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      // Async validators are passed as the 3rd argument
      studentEmail: ['', [Validators.required, Validators.email], [simulateEmailCheck]],
      courseId: ['', [Validators.required, noCourseCode]],
      preferredSemester: ['Odd', [Validators.required]],
      agreeToTerms: [false, [Validators.requiredTrue]],
      additionalCourses: this.fb.array([])
    });
  }

  /* 
    CODE COMMENT EXPLANATION: FormArray Getter
    Using a typed getter abstracts away the Type assertion `as FormArray` from the HTML template. 
    Angular templates cannot perform strict TypeScript casting directly, so handling it here ensures 
    strict typing, prevents compilation errors in AOT, and keeps the template clean.
  */
  get additionalCourses(): FormArray {
    return this.enrollForm.get('additionalCourses') as FormArray;
  }

  addCourse(): void {
    this.additionalCourses.push(this.fb.control('', Validators.required));
  }

  removeCourse(index: number): void {
    this.additionalCourses.removeAt(index);
  }

  onSubmit(): void {
    /* 
      CODE COMMENT EXPLANATION: .value vs .getRawValue()
      enrollForm.value returns an object containing only the values of enabled form controls.
      enrollForm.getRawValue() returns an object containing all values, including those from disabled controls.
    */
    console.log('Form Value (Excludes disabled):', this.enrollForm.value);
    console.log('Raw Value (Includes disabled):', this.enrollForm.getRawValue());
    console.log('Is Form Valid?', this.enrollForm.valid);
  }
}