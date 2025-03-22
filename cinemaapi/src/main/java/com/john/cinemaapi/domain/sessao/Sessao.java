package com.john.cinemaapi.domain.sessao;

import com.john.cinemaapi.domain.filme.Filme;
import com.john.cinemaapi.domain.sala.Sala;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Filme filme;

    @ManyToOne
    private Sala sala;

    private LocalDateTime horario;
}