import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  sidebarVisible: boolean = false;
  menuItems: MenuItem[] = [];

  constructor() {
    this.menuItems = [
      { label: 'Accueil', icon: 'pi pi-home' },
      { label: 'Resultats', icon: 'pi pi-info', url: 'results' },
      { label: 'Athletes', icon: 'pi pi-info' },
      { label: 'Pays', icon: 'pi pi-search' }
    ];
  }
}