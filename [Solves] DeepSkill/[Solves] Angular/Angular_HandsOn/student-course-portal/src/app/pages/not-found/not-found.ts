import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-not-found',
  standalone: true,
  imports: [RouterLink],
  template: `
    <div style="text-align: center; margin-top: 50px;">
      <h1>404</h1>
      <h2>Page Not Found</h2>
      <a routerLink="/">Go back home</a>
    </div>
  `
})
export class NotFoundComponent {}