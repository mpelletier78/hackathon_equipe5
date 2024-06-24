import { Component } from '@angular/core';
import {TableModule} from "primeng/table";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-accueil',
  standalone: true,
  imports: [
    TableModule,
    NgForOf
  ],
  templateUrl: './accueil.component.html',
  styleUrl: './accueil.component.css'
})
export class AccueilComponent {
  // Define the data for the table
  data = [
    { position: 2, pays: 'USA', or: 3, argent: 5, bronze: 0 },
    { position: 1, pays: 'France', or: 5, argent: 4, bronze: 2 },
    // Add more data as needed
  ];

  // Define the columns for the table
  cols = [
    { field: 'position', header: 'Position' },
    { field: 'pays', header: 'Pays' },
    { field: 'or', header: 'Or 🥇' },
    { field: 'argent', header: 'Argent 🥈' },
    { field: 'bronze', header: 'Bronze 🥉' },
  ];
}
