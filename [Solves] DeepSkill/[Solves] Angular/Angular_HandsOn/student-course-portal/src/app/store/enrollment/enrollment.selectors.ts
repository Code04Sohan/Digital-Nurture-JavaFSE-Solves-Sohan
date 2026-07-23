import { createFeatureSelector, createSelector } from '@ngrx/store';
import { EnrollmentState } from './enrollment.reducer';
import { selectAllCourses } from '../course/course.selectors';

export const selectEnrollmentState = createFeatureSelector<EnrollmentState>('enrollment');
export const selectEnrolledIds = createSelector(selectEnrollmentState, state => state.enrolledCourseIds);

/* 
  CODE COMMENT EXPLANATION: Cross-Slice Selectors
  This selector combines data from the Course slice (selectAllCourses) and the Enrollment 
  slice (selectEnrolledIds) to build out the full course objects without duplicating data 
  in the state tree.
*/
export const selectEnrolledCourses = createSelector(
  selectAllCourses,
  selectEnrolledIds,
  (courses, enrolledIds) => courses.filter(course => enrolledIds.includes(course.id))
);