package br.com.atividade03.controllers;

import br.com.atividade03.dtos.SetorDTO;
import br.com.atividade03.dtos.queryreqs.RetornaTodosOsSetoresComFuncionariosDTO;
import br.com.atividade03.models.Setor;
import br.com.atividade03.service.SetorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setor")
public class SetorController {

    @Autowired
    private SetorServiceImpl setorServiceImpl;

    @GetMapping()
    public RetornaTodosOsSetoresComFuncionariosDTO buscaTodosOsSetoresComFuncionarios() {
        return setorServiceImpl.buscaSetorMaisFuncionarios();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(SetorDTO setorDTO) {
        setorServiceImpl.adicionar(setorDTO);
    }
}