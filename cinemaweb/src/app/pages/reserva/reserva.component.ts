import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SessaoService } from '../../core/services/sessao.service';
import { UsuarioService } from '../../core/services/usuario.service';
import { ReservaService } from '../../core/services/reserva.service';
import { Sessao } from '../../core/models/sessao.model';
import { Usuario } from '../../core/models/usuario.model';
import { Reserva } from '../../core/models/reserva.model';
import { CriarReserva } from '../../core/models/criar-reserva.model';

@Component({
  selector: 'app-reserva',
  templateUrl: './reserva.component.html'
})
export class ReservaComponent implements OnInit {
  sessaoId!: number;
  sessao!: Sessao;
  nome = '';
  email = '';
  assento!: number;

  constructor(
    private route: ActivatedRoute,
    private sessaoService: SessaoService,
    private usuarioService: UsuarioService,
    private reservaService: ReservaService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.sessaoId = Number(this.route.snapshot.paramMap.get('id'));
    this.sessaoService.buscarPorId(this.sessaoId).subscribe({
      next: (sessao) => this.sessao = sessao,
      error: () => alert('Sessão não encontrada')
    });
  }

  reservar() {
    const novoUsuario: Partial<Usuario> = {
      nome: this.nome,
      email: this.email
    };

    this.usuarioService.criar(novoUsuario as Usuario).subscribe({
      next: (usuario) => {
        console.log('Usuario criado:', usuario);
        const novaReserva: Partial<CriarReserva> = {
          usuarioId: usuario.id,
          sessaoId: this.sessao.id,
          assento: this.assento
        };

        this.reservaService.criar(novaReserva as Reserva).subscribe({
          next: () => {
            alert('Reserva realizada com sucesso!');
            this.router.navigate(['/minhas-reservas']);
          },
          error: () => alert('Erro ao criar reserva')
        });
      },
      error: () => alert('Erro ao criar usuário')
    });
  }
}