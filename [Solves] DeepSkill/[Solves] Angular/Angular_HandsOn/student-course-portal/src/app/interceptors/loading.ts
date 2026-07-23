import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { finalize } from 'rxjs';
import { LoadingService } from '../services/loading';

export const loadingInterceptor: HttpInterceptorFn = (req, next) => {
  const loadingService = inject(LoadingService);
  
  // Turn on the loading spinner before the request leaves
  loadingService.isLoading$.next(true);

  return next(req).pipe(
    // finalize runs whether the Observable completes successfully or throws an error
    finalize(() => loadingService.isLoading$.next(false))
  );
};