import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ReservaComponent } from './pages/reserva/reserva.component';
import { MinhasReservasComponent } from './pages/minhas-reservas/minhas-reservas.component';

import { FilmesComponent } from './pages/admin/filmes/filmes.component';
import { SalasComponent } from './pages/admin/salas/salas.component';
import { SessoesComponent } from './pages/admin/sessoes/sessoes.component';

const routes: Routes = [
  { path: 'sessoes', component: HomeComponent },
  { path: 'reserva/:id', component: ReservaComponent },
  { path: 'minhas-reservas', component: MinhasReservasComponent },
  { path: 'admin/filmes', component: FilmesComponent },
  { path: 'admin/salas', component: SalasComponent },
  { path: 'admin/sessoes', component: SessoesComponent },
  { path: '**', redirectTo: 'sessoes' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}