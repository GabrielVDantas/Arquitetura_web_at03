package br.com.atividade03.dtos;

import lombok.Builder;

@Builder
public record FuncionarioDTO(
        String name
) {
}
