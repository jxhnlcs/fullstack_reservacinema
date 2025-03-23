import { Component, OnInit } from '@angular/core';
import { SessaoService } from '../../core/services/sessao.service';
import { Sessao } from '../../core/models/sessao.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {
  sessoes: Sessao[] = [];

  constructor(private sessaoService: SessaoService) {}

  ngOnInit(): void {
    this.sessaoService.listar().subscribe({
      next: (dados) => this.sessoes = dados,
      error: (err) => console.error('Erro ao buscar sessões:', err)
    });
  }
}