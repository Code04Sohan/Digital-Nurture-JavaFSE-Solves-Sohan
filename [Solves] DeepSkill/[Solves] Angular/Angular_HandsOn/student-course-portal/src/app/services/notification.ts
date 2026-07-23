import { Injectable } from '@angular/core';

@Injectable() // Notice: { providedIn: 'root' } is REMOVED
export class NotificationService {
  messages: string[] = [];
  add(message: string) { this.messages.push(message); }
}