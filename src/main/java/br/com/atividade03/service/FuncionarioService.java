package br.com.atividade03.service;

import br.com.atividade03.dtos.FuncionarioDTO;
import br.com.atividade03.dtos.queryreqs.RetornaProjetosDoFuncionarioDTO;
import br.com.atividade03.models.Projeto;

import java.util.List;

public interface FuncionarioService {

    RetornaProjetosDoFuncionarioDTO getProjetosComDeterminadoFuncionario(Long funcionarioId);

    void adicionar(FuncionarioDTO funcionarioDTO);

    void ver();

    void atualizar(Long id, String name);

    void deletar(Long id);

}
