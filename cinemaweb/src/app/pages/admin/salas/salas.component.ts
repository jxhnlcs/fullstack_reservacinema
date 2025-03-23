import { Component, OnInit } from '@angular/core';
import { SalaService } from '../../../core/services/sala.service';
import { Sala } from '../../../core/models/sala.model';

@Component({
  selector: 'app-salas',
  templateUrl: './salas.component.html'
})
export class SalasComponent implements OnInit {
  nome = '';
  capacidade!: number;
  salas: Sala[] = [];

  constructor(private salaService: SalaService) {}

  ngOnInit(): void {
    this.carregarSalas();
  }

  carregarSalas() {
    this.salaService.listar().subscribe({
      next: (res) => this.salas = res
    });
  }

  cadastrar() {
    if (!this.nome || !this.capacidade) {
      alert('Preencha todos os campos!');
      return;
    }

    const novaSala: Partial<Sala> = {
      nome: this.nome,
      capacidade: this.capacidade
    };

    this.salaService.criar(novaSala as Sala).subscribe({
      next: () => {
        alert('Sala cadastrada!');
        this.nome = '';
        this.capacidade = 0;
        this.carregarSalas();
      }
    });
  }
}