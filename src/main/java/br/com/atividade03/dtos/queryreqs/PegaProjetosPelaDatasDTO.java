package br.com.atividade03.dtos.queryreqs;

import java.time.LocalDate;

public record PegaProjetosPelaDatasDTO(
        LocalDate dataInicio,
        LocalDate dataFim
) {
}
