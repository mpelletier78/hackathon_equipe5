import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {SidebarModule} from 'primeng/sidebar';
import {ToolbarModule} from 'primeng/toolbar';
import {AppComponent} from './app.component';
import {RouterModule, Routes} from '@angular/router';
import {AccueilComponent} from './accueil/accueil.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MenuModule} from 'primeng/menu';
import {ResultatsComponent} from "./resultats/resultats.component";
import {HttpClientModule} from "@angular/common/http";

// Définition des routes
const routes: Routes = [
    {path: '', component: AccueilComponent}, // Route pour la page d'accueil
    {path: 'resultats', component: ResultatsComponent} // Route pour la page d'accueil
    // Ajoutez d'autres routes ici
];

@NgModule({
    declarations: [AppComponent],
    imports: [
        BrowserModule,
        SidebarModule,
        ToolbarModule,
        MenuModule,
        BrowserAnimationsModule,
        HttpClientModule,
        RouterModule.forRoot(routes)
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
