import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-event-details',
  standalone: true,
  imports: [],
  templateUrl: './event-details.component.html',
  styleUrl: './event-details.component.css'
})
export class EventDetailsComponent {
  event: any;

  constructor(private route: ActivatedRoute){
    const eventId = this.route.snapshot.paramMap.get('id')
    this.event = {
      id: eventId,
      name: "Tech Conference 2024",
      date: " Aug 15, 2024",
      location: " Toronto",
      description: " A conference about the latest tech trends."
    };
  }
}
