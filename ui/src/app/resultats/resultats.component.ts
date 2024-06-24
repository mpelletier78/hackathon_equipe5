import {Component} from '@angular/core';
import {TableModule} from "primeng/table";
import {NgForOf, NgIf} from "@angular/common";
import {DialogModule} from "primeng/dialog";

@Component({
  selector: 'app-resultats',
  standalone: true,
  imports: [
    TableModule,
    NgForOf,
    DialogModule,
    NgIf
  ],
  templateUrl: './resultats.component.html',
  styleUrl: './resultats.component.css'
})
export class ResultatsComponent {

  selectedSport?: Sport = undefined;
  displayDialog: boolean = false;

  onRowSelect(sport: Sport) {
    this.selectedSport = sport;
    this.displayDialog = true;
  }

  // Sample data of Sport
  sports: Sport[] = [
    {
      name: 'Men\'s 200 Metres',
      round: 'Round 1 - Heat 4',
      first: 'Usain Bolt',
      second: 'Justin Gatlin',
      third: 'Andre De Grasse',
      classement: [
        {
          nom: 'Usain Bolt',
          nationalite: 'JAM',
          place: 1,
          temps: 19.78
        },
        {
          nom: 'Justin Gatlin',
          nationalite: 'USA',
          place: 2,
          temps: 20.02
        },
        {
          nom: 'Andre De Grasse',
          nationalite: 'CAN',
          place: 3,
          temps: 20.02
        },
        {
          nom: 'Yohan Blake',
          nationalite: 'JAM',
          place: 4,
          temps: 20.15
        },
        {
          nom: 'Adam Gemili',
          nationalite: 'GBR',
          place: 5,
          temps: 20.20
        }
      ]
    },
    {
      name: 'Men\'s 200 Metres',
      round: 'Round 1 - Heat 5',
      first: 'Athlete One',
      second: 'Athlete Two',
      third: 'Athlete Three',
      classement: [
        {
          nom: 'Athlete One',
          nationalite: 'USA',
          place: 1,
          temps: 19.78
        },
        {
          nom: 'Athlete Two',
          nationalite: 'GBR',
          place: 2,
          temps: 20.02
        },
        {
          nom: 'Athlete Three',
          nationalite: 'CAN',
          place: 3,
          temps: 20.02
        },
        {
          nom: 'Athlete Four',
          nationalite: 'JAM',
          place: 4,
          temps: 20.15
        },
        {
          nom: 'Athlete Five',
          nationalite: 'AUS',
          place: 5,
          temps: 20.20
        }
      ]
    },
    {
      name: 'Men\'s 200 Metres', round: 'Final', first: 'Runner One', second: 'Runner Two', third: 'Runner Three',
      classement: [
        {
          nom: 'Runner One',
          nationalite: 'USA',
          place: 1,
          temps: 19.78
        },
        {
          nom: 'Runner Two',
          nationalite: 'GBR',
          place: 2,
          temps: 20.02
        },
        {
          nom: 'Runner Three',
          nationalite: 'CAN',
          place: 3,
          temps: 20.02
        },
        {
          nom: 'Runner Four',
          nationalite: 'JAM',
          place: 4,
          temps: 20.15
        },
        {
          nom: 'Runner Five',
          nationalite: 'AUS',
          place: 5,
          temps: 20.20
        }
      ]
    }
  ]
  // Define the columns for the table
  colsSports = [
    {field: 'name', header: 'Sport'},
    {field: 'round', header: 'Round'},
    {field: 'first', header: 'First'},
    {field: 'second', header: 'Second'},
    {field: 'third', header: 'Third'},
  ];

  hide() {
    this.selectedSport = undefined
  }
}

export interface Sport {
  name: string;
  round: string;
  first: string;
  second: string;
  third: string;
  classement: Classement[];
}

export interface Epreuve {
  HOUR: string;
  ROUND: string;
  SPORT: string;
  NAME: string;
  BIRTH_DATE: string;
  NAT: string;
  PLACE: number;
  MARK: number;
}

export interface Classement {
  nom: string;
  nationalite: string;
  place: number;
  temps: number;
}
