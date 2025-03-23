import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Filme } from '../models/filme.model';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({ providedIn: 'root' })
export class FilmeService {
  private apiUrl = environment.apiUrl + '/filmes';

  constructor(private http: HttpClient) {}

  listar(): Observable<Filme[]> {
    return this.http.get<Filme[]>(this.apiUrl);
  }

  buscarPorId(id: number): Observable<Filme> {
    return this.http.get<Filme>(`${this.apiUrl}/${id}`);
  }

  criar(filme: Filme): Observable<Filme> {
    return this.http.post<Filme>(this.apiUrl, filme);
  }

  deletar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}