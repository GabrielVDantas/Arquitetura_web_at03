package br.com.atividade03.dtos.queryreqs;

import br.com.atividade03.dtos.FuncionarioDTO;
import br.com.atividade03.dtos.SetorDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record RetornaTodosOsSetoresComFuncionariosDTO(
        List<SetorDTO> setorDTOList
) {
}
