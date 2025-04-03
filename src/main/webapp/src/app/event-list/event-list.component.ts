import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-event-list',
  standalone: true,
  imports: [CommonModule, MatCardModule, RouterModule],
  templateUrl: './event-list.component.html',
  styleUrl: './event-list.component.css'
})
export class EventListComponent {
  events = [
    {id: 1, name: "Tech Conference 2024", date: "Aug 15, 2024", location: "Toronto"},
    {id: 2, name: "Startup Meetup", date: "Sept 5, 2024", location: "New York"}
  ]
}
