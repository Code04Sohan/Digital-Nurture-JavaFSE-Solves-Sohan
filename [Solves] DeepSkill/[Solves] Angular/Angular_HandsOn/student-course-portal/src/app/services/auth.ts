import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class AuthService {
  // Set to true to access profile, false to test the redirect
  isLoggedIn: boolean = false; 
}