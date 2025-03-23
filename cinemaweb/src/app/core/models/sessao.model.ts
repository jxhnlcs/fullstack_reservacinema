import { Filme } from './filme.model';
import { Sala } from './sala.model';

export interface Sessao {
  id: number;
  filme: Filme;
  sala: Sala;
  horario: string;
}