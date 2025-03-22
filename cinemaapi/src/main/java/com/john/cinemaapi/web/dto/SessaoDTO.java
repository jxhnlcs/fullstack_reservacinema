package com.john.cinemaapi.web.dto;

import lombok.Data;

@Data
public class SessaoDTO {
    private Long filmeId;
    private Long salaId;
    private String horario;
}