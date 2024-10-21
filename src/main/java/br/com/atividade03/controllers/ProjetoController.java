package br.com.atividade03.controllers;

import br.com.atividade03.dtos.ProjetoDTO;
import br.com.atividade03.dtos.queryreqs.PegaFuncionarioPeloProjetoDTO;
import br.com.atividade03.dtos.queryreqs.PegaProjetosPelaDatasDTO;
import br.com.atividade03.dtos.queryreqs.RetornaProjetoComFuncionariosDTO;
import br.com.atividade03.dtos.queryreqs.RetornaProjetosPelaDatasDTO;
import br.com.atividade03.models.Projeto;
import br.com.atividade03.service.ProjetoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoServiceImpl projetoServiceImpl;

    @GetMapping("/funcionarios")
    public RetornaProjetoComFuncionariosDTO buscarProjetoPorId(@RequestBody PegaFuncionarioPeloProjetoDTO dto) {
        return projetoServiceImpl.buscaProjetoPorIdEFuncionariosTambem(dto.id());
    }

    @GetMapping("/entre-datas")
    public RetornaProjetosPelaDatasDTO buscaProjetosEntreDatas(@RequestBody PegaProjetosPelaDatasDTO dto) {
        return projetoServiceImpl.buscaProjetosEntreDatas(dto.dataInicio(), dto.dataFim());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(ProjetoDTO projetoDTO) {
        projetoServiceImpl.adicionar(projetoDTO);
    }

    @PutMapping()
    public void vincularFuncionario(Long projetoId, Long funcionarioId) {
        projetoServiceImpl.vinculaFuncionarioAoProjeto(projetoId, funcionarioId);
    }
}