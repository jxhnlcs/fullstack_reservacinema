package com.john.cinemaapi.web.dto;

import lombok.Data;

@Data
public class FilmeDTO {
    private String titulo;
    private String descricao;
    private Integer duracaoEmMinutos;
}