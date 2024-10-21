package br.com.atividade03.dtos;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ProjetoDTO(
        String description,
        LocalDate dataInicio,
        LocalDate dataFim
) {
}
