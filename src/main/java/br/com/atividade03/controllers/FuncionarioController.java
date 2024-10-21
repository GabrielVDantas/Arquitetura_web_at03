package br.com.atividade03.controllers;

import br.com.atividade03.dtos.FuncionarioDTO;
import br.com.atividade03.dtos.queryreqs.PegaProjetosDoFuncionarioDTO;
import br.com.atividade03.dtos.queryreqs.RetornaProjetosDoFuncionarioDTO;
import br.com.atividade03.models.Projeto;
import br.com.atividade03.service.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioServiceImpl funcionarioServiceImpl;

    @GetMapping()
    public RetornaProjetosDoFuncionarioDTO buscarProjetosDoFuncionario(@RequestBody PegaProjetosDoFuncionarioDTO dto) {
        return funcionarioServiceImpl.getProjetosComDeterminadoFuncionario(dto.id());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(FuncionarioDTO funcionarioDTO) {
        funcionarioServiceImpl.adicionar(funcionarioDTO);
    }
}