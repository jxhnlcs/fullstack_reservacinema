package com.john.cinemaapi.domain.reserva;

import com.john.cinemaapi.domain.usuario.Usuario;
import com.john.cinemaapi.domain.sessao.Sessao;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Sessao sessao;

    private Integer assento;
}