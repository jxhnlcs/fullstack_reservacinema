package com.john.cinemaapi.web.dto;

import lombok.Data;

@Data
public class ReservaDTO {
    private Long usuarioId;
    private Long sessaoId;
    private Integer assento;
}