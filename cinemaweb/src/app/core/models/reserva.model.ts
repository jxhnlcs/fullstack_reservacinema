import { Usuario } from './usuario.model';
import { Sessao } from './sessao.model';

export interface Reserva {
  id: number;
  usuario: Usuario;
  sessao: Sessao;
  assento: number;
}