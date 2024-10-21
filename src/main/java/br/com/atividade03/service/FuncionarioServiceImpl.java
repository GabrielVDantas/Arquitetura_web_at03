package br.com.atividade03.service;

import br.com.atividade03.dtos.FuncionarioDTO;
import br.com.atividade03.dtos.ProjetoDTO;
import br.com.atividade03.dtos.queryreqs.RetornaProjetosDoFuncionarioDTO;
import br.com.atividade03.models.Funcionario;
import br.com.atividade03.models.Projeto;
import br.com.atividade03.repositories.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public RetornaProjetosDoFuncionarioDTO getProjetosComDeterminadoFuncionario(Long funcionarioId) {
        List<Projeto> projetos = funcionarioRepository.findProjetosDoFuncionarioComBaseNoSeuID(funcionarioId);
        List<ProjetoDTO> projetoDTOList = projetos.stream().map((Projeto p) -> {
            return ProjetoDTO.builder()
                    .description(p.getDescription())
                    .dataInicio(p.getDataInicio())
                    .dataFim(p.getDataFim())
                    .build();
        }).toList();
        return RetornaProjetosDoFuncionarioDTO.builder()
                .projetoDTOList(projetoDTOList)
                .build();
    }

    @Transactional
    public void adicionar(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario(funcionarioDTO.name());
        funcionarioRepository.save(funcionario);
    }

    public void ver() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
    }

    @Transactional
    public void atualizar(Long id, String name) {
        Funcionario funcionario = funcionarioRepository.getReferenceById(id);
        funcionario.setName(name);
        funcionarioRepository.save(funcionario);
    }

    public void deletar(Long id) {
        Funcionario funcionario = funcionarioRepository.getReferenceById(id);
        funcionarioRepository.delete(funcionario);
    }
}
