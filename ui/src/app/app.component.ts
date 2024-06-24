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
      { label: 'Accueil', icon: 'pi pi-home', routerLink: '/' },
      { label: 'Resultats', icon: 'pi pi-wave-pulse', routerLink: '/resultats' },
      { label: 'Athletes', icon: 'pi pi-users', routerLink: '/athletes' },
      { label: 'Pays', icon: 'pi pi-search', routerLink: '/pays' },
    ];
  }
}
