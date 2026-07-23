import { Component } from '@angular/core';
import { RouterLink } from '@angular/router'; // <-- 1. Import this


@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink], // <-- 2. Add it to the imports array
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class HeaderComponent { }