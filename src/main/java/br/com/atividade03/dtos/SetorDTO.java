package br.com.atividade03.dtos;

import lombok.Builder;

import java.util.List;

@Builder
public record SetorDTO(
        String name,

        List<FuncionarioDTO> funcionarioDTOList
) {
}
