import { Component, OnInit } from '@angular/core';
import { ReservaService } from '../../core/services/reserva.service';
import { Reserva } from '../../core/models/reserva.model';

@Component({
  selector: 'app-minhas-reservas',
  templateUrl: './minhas-reservas.component.html'
})
export class MinhasReservasComponent implements OnInit {
  reservas: Reserva[] = [];

  constructor(private reservaService: ReservaService) {}

  ngOnInit(): void {
    this.reservaService.listar().subscribe({
      next: (res) => this.reservas = res,
      error: () => alert('Erro ao carregar reservas')
    });
  }
}