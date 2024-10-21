package br.com.atividade03.service;

import br.com.atividade03.dtos.FuncionarioDTO;
import br.com.atividade03.dtos.SetorDTO;
import br.com.atividade03.dtos.queryreqs.RetornaTodosOsSetoresComFuncionariosDTO;
import br.com.atividade03.models.Setor;

import java.util.List;

public interface SetorService {

    RetornaTodosOsSetoresComFuncionariosDTO buscaSetorMaisFuncionarios();
    void adicionar(SetorDTO setorDTO);

    void ver();

    void atualizar(Long id, String name);

    void deletar(Long id);
}
