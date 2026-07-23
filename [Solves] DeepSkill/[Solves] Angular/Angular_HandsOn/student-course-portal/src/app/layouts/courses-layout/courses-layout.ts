import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-courses-layout',
  standalone: true,
  imports: [RouterOutlet],
  template: `
    <div class="layout-container">
      <h2>Courses Section</h2>
      <hr>
      <router-outlet></router-outlet> 
    </div>
  `
})
export class CoursesLayoutComponent {}