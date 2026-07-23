import { Component } from '@angular/core';
import { NotificationService } from '../../services/notification';

@Component({
  selector: 'app-notification',
  standalone: true,
  /* 
    CODE COMMENT EXPLANATION: Component-level providing.
    Providing the service in the @Component decorator creates a brand new, isolated 
    instance of the NotificationService specific to THIS component and its children. 
    It is destroyed when the component is destroyed, and its data is not shared 
    with the rest of the application (unlike 'root' providers).
  */
  providers: [NotificationService], 
  template: `<p>Notifications: {{ notificationService.messages.length }}</p>`
})
export class NotificationComponent {
  constructor(public notificationService: NotificationService) {}
}