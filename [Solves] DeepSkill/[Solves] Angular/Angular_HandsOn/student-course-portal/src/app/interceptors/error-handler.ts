import { HttpInterceptorFn, HttpErrorResponse } from '@angular/common/http';
import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';

export const errorHandlerInterceptor: HttpInterceptorFn = (req, next) => {
  const router = inject(Router);

  return next(req).pipe(
    catchError((error: HttpErrorResponse) => {
      if (error.status === 401) {
        console.error('Unauthorized! Redirecting to login...');
        router.navigate(['/']);
      } else if (error.status === 500) {
        console.error('Server error! Notify user.');
        alert('A global server error occurred.'); // Basic global notification
      }
      return throwError(() => error);
    })
  );
};