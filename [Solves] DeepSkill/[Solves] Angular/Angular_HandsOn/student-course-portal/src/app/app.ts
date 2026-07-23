import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './components/header/header';
// HomeComponent import removed

@Component({
  selector: 'app-root',
  standalone: true,
  // HomeComponent removed from the imports array
  imports: [RouterOutlet, HeaderComponent], 
  templateUrl: './app.html',
  styleUrl: './app.css'
})
// Renamed from App to AppComponent
export class AppComponent {
  title = 'student-course-portal';
}