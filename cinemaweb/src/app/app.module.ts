import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentsModule } from './components/components.module';
import { HomeComponent } from './pages/home/home.component';
import { ReservaComponent } from './pages/reserva/reserva.component';
import { MinhasReservasComponent } from './pages/minhas-reservas/minhas-reservas.component';
import { FilmesComponent } from './pages/admin/filmes/filmes.component';
import { SalasComponent } from './pages/admin/salas/salas.component';
import { SessoesComponent } from './pages/admin/sessoes/sessoes.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ReservaComponent,
    MinhasReservasComponent,
    FilmesComponent,
    SalasComponent,
    SessoesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ComponentsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }