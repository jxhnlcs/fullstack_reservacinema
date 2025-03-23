import { Component, OnInit } from '@angular/core';
import { SessaoService } from '../../../core/services/sessao.service';
import { FilmeService } from '../../../core/services/filme.service';
import { SalaService } from '../../../core/services/sala.service';
import { Filme } from '../../../core/models/filme.model';
import { Sala } from '../../../core/models/sala.model';
import { Sessao } from '../../../core/models/sessao.model';
import { CriarSessao } from '../../../core/models/criar-sessao.model';

@Component({
  selector: 'app-sessoes',
  templateUrl: './sessoes.component.html'
})
export class SessoesComponent implements OnInit {
  filmes: Filme[] = [];
  salas: Sala[] = [];
  sessoes: Sessao[] = [];

  filmeId!: number;
  salaId!: number;
  horario!: string;

  constructor(
    private sessaoService: SessaoService,
    private filmeService: FilmeService,
    private salaService: SalaService
  ) {}

  ngOnInit(): void {
    this.filmeService.listar().subscribe(filmes => this.filmes = filmes);
    this.salaService.listar().subscribe(salas => this.salas = salas);
    this.sessaoService.listar().subscribe(s => this.sessoes = s);
  }

  cadastrar() {
    if (!this.filmeId || !this.salaId || !this.horario) {
      alert('Preencha todos os campos!');
      return;
    }

    const CriarSessao = {
      filmeId: this.filmeId,
      salaId: this.salaId,
      horario: this.horario
    };

    this.sessaoService.criar(CriarSessao).subscribe(() => {
      alert('Sessão cadastrada!');
      this.horario = '';
      this.filmeId = 0;
      this.salaId = 0;
      this.sessaoService.listar().subscribe(s => this.sessoes = s);
    });
  }
}
