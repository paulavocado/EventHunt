import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  imports: [CommonModule, MatButtonModule, MatCardModule, MatInputModule, FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  name = '';
  email = '';
  password = '';

  onRegister(){
    console.log('Registering user: ', this.name, this.email, this.password);
    alert('Registration Successful')
  }
}
