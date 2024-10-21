package br.com.atividade03.dtos.queryreqs;

import br.com.atividade03.dtos.ProjetoDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record RetornaProjetosPelaDatasDTO(
        List<ProjetoDTO> projetoDTOList
) {
}
