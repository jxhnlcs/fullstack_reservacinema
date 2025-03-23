import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Sessao } from '../models/sessao.model';
import { CriarSessao } from '../models/criar-sessao.model';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({ providedIn: 'root' })
export class SessaoService {
  private apiUrl = environment.apiUrl + '/sessoes';

  constructor(private http: HttpClient) {}

  listar(): Observable<Sessao[]> {
    return this.http.get<Sessao[]>(this.apiUrl);
  }

  buscarPorId(id: number): Observable<Sessao> {
    return this.http.get<Sessao>(`${this.apiUrl}/${id}`);
  }

  criar(criarSessao: CriarSessao): Observable<CriarSessao> {
    return this.http.post<CriarSessao>(this.apiUrl, criarSessao);
  }

  deletar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}