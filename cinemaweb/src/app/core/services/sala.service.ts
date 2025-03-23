import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Sala } from '../models/sala.model';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({ providedIn: 'root' })
export class SalaService {
  private apiUrl = environment.apiUrl + '/salas';

  constructor(private http: HttpClient) {}

  listar(): Observable<Sala[]> {
    return this.http.get<Sala[]>(this.apiUrl);
  }

  buscarPorId(id: number): Observable<Sala> {
    return this.http.get<Sala>(`${this.apiUrl}/${id}`);
  }

  criar(sala: Sala): Observable<Sala> {
    return this.http.post<Sala>(this.apiUrl, sala);
  }

  deletar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}