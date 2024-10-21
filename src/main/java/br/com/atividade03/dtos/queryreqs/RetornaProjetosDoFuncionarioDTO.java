package br.com.atividade03.dtos.queryreqs;

import br.com.atividade03.dtos.FuncionarioDTO;
import br.com.atividade03.dtos.ProjetoDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record RetornaProjetosDoFuncionarioDTO(

        List<ProjetoDTO> projetoDTOList
) {
}
