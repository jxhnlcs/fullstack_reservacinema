import { Component } from '@angular/core';
import { FilmeService } from '../../../core/services/filme.service';
import { Filme } from '../../../core/models/filme.model';

@Component({
  selector: 'app-filmes',
  templateUrl: './filmes.component.html'
})
export class FilmesComponent {
  titulo = '';
  descricao = '';
  duracaoEmMinutos!: number;
  filmes: Filme[] = [];

  constructor(private filmeService: FilmeService) {}

  ngOnInit(): void {
    this.listarFilmes();
  }

  listarFilmes() {
    this.filmeService.listar().subscribe({
      next: (dados) => this.filmes = dados
    });
  }

  cadastrar() {
    if (!this.titulo || !this.descricao || !this.duracaoEmMinutos) return alert('Preencha todos os campos!');

    const novo: Partial<Filme> = {
      titulo: this.titulo,
      descricao: this.descricao,
      duracaoEmMinutos: this.duracaoEmMinutos
    };

    this.filmeService.criar(novo as Filme).subscribe({
      next: () => {
        alert('Filme cadastrado!');
        this.titulo = '';
        this.descricao = '';
        this.duracaoEmMinutos = 0;
        this.listarFilmes();
      }
    });
  }
}