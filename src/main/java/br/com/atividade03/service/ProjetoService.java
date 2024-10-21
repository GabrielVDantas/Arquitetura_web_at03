package br.com.atividade03.service;

import br.com.atividade03.dtos.ProjetoDTO;
import br.com.atividade03.dtos.queryreqs.RetornaProjetoComFuncionariosDTO;
import br.com.atividade03.dtos.queryreqs.RetornaProjetosPelaDatasDTO;
import br.com.atividade03.models.Funcionario;
import br.com.atividade03.models.Projeto;

import java.time.LocalDate;
import java.util.List;

public interface ProjetoService {

    void vinculaFuncionarioAoProjeto(Long projetoId, Long funcionarioId);

    RetornaProjetoComFuncionariosDTO buscaProjetoPorIdEFuncionariosTambem(Long id);

    RetornaProjetosPelaDatasDTO buscaProjetosEntreDatas(LocalDate dataUm, LocalDate dataDois);

    void adicionar(ProjetoDTO projetoDTO);

    void ver();

    void atualizar(Long id, String description);

    void deletar(Long id);
}
