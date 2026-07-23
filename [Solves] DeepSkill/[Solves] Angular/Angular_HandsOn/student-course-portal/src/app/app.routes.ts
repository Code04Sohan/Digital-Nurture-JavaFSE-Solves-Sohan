import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home';
import { CoursesLayoutComponent } from './layouts/courses-layout/courses-layout';
import { CourseListComponent } from './pages/course-list/course-list';
import { CourseDetailComponent } from './pages/course-detail/course-detail';
import { StudentProfileComponent } from './pages/student-profile/student-profile';
import { NotFoundComponent } from './pages/not-found/not-found';
import { authGuard } from './guards/auth-guard';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  
  // Nested Routes
  { 
    path: 'courses', 
    component: CoursesLayoutComponent,
    children: [
      { path: '', component: CourseListComponent },
      { path: ':id', component: CourseDetailComponent }
    ]
  },
  
  // Standalone Lazy Loading
  { 
    path: 'enroll', 
    loadChildren: () => import('./features/enrollment/enrollment.routes').then(m => m.ENROLLMENT_ROUTES)
  },
  
  // Protected Route via CanActivate Guard
  { 
    path: 'profile', 
    component: StudentProfileComponent,
    canActivate: [authGuard] 
  },
  
  // Wildcard Route (Must be last)
  { path: '**', component: NotFoundComponent }
];