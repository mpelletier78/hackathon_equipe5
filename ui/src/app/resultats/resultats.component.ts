// @ts-nocheck
import {Component, OnInit} from '@angular/core';
import {TableModule} from "primeng/table";
import {NgForOf, NgIf} from "@angular/common";
import {DialogModule} from "primeng/dialog";
import {HttpClient} from "@angular/common/http";

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
export class ResultatsComponent implements OnInit {

    selectedSport?: Sport = undefined;
    displayDialog: boolean = false;

    constructor(private http: HttpClient) {
    }

    ngOnInit() {
        this.http.get<Epreuve[]>('http://localhost:8080/resultat').subscribe(data => {
            // @ts-ignore
            data = data['resultat'];

            for (let round of Object.keys(data[`50m nage libre`])) {
                var players = data[`50m nage libre`][round].sort((a, b) => parseInt(a.place) - parseInt(b.place));

                this.sports.push({
                    name: '50m nage libre',
                    round: round,
                    first: players[0].name,
                    second: players[1].name,
                    third: players[2].name,
                    classement: players.map(obj => ({
                        nom: obj.name,
                        nationalite: obj.nat,
                        place: obj.place,
                        temps: obj.mark
                    }))
                });
            }
        })
    }

    onRowSelect(sport: Sport) {
        this.selectedSport = sport;
        this.displayDialog = true;
    }

    // Sample data of Sport
    sports: Sport[] = []

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
