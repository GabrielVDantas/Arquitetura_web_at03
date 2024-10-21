package br.com.atividade03.service;

import br.com.atividade03.dtos.FuncionarioDTO;
import br.com.atividade03.dtos.ProjetoDTO;
import br.com.atividade03.dtos.queryreqs.RetornaProjetoComFuncionariosDTO;
import br.com.atividade03.dtos.queryreqs.RetornaProjetosPelaDatasDTO;
import br.com.atividade03.models.Funcionario;
import br.com.atividade03.models.Projeto;
import br.com.atividade03.repositories.FuncionarioRepository;
import br.com.atividade03.repositories.ProjetoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjetoServiceImpl implements ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public RetornaProjetoComFuncionariosDTO buscaProjetoPorIdEFuncionariosTambem(Long id) {
        Projeto projeto = projetoRepository.findProjetoByIdAndFuncionarios(id);
        ProjetoDTO projetoDTO = ProjetoDTO.builder()
                .description(projeto.getDescription())
                .dataInicio(projeto.getDataInicio())
                .dataFim(projeto.getDataFim())
                .build();
        List<FuncionarioDTO> funcionarioDTOList = projeto.getFuncionariosDoProjeto().stream().map((Funcionario f) -> {
            return FuncionarioDTO.builder()
                    .name(f.getName())
                    .build();
        }).toList();
        return RetornaProjetoComFuncionariosDTO.builder()
                .projeto(projetoDTO)
                .funcionarios(funcionarioDTOList)
                .build();
    }

    @Override
    public RetornaProjetosPelaDatasDTO buscaProjetosEntreDatas(LocalDate dataUm, LocalDate dataDois) {
        List<Projeto> projetos = projetoRepository.findTodosOsProjetosQueIniciamEntreAsDatas(dataUm, dataDois);
        List<ProjetoDTO> projetoDTOList = projetos.stream().map((Projeto p) -> {
            return ProjetoDTO.builder()
                    .description(p.getDescription())
                    .dataInicio(p.getDataInicio())
                    .dataFim(p.getDataFim())
                    .build();
        }).toList();
        return RetornaProjetosPelaDatasDTO.builder()
                .projetoDTOList(projetoDTOList)
                .build();
    }

    @Override
    public void vinculaFuncionarioAoProjeto(Long projetoId, Long funcionarioId) {
        Projeto projeto = projetoRepository.getReferenceById(projetoId);
        Funcionario funcionario = funcionarioRepository.getReferenceById(funcionarioId);
        projeto.setFuncionariosDoProjeto((List<Funcionario>) funcionario);
        projetoRepository.save(projeto);
    }

    @Transactional
    public void adicionar(ProjetoDTO projetoDTO) {
        Projeto projeto = new Projeto(projetoDTO.description(), projetoDTO.dataInicio(), projetoDTO.dataFim());
        projetoRepository.save(projeto);
    }

    public void ver() {
        List<Projeto> projetos = projetoRepository.findAll();
    }

    @Transactional
    public void atualizar(Long id, String description) {
        Projeto projeto = projetoRepository.getReferenceById(id);
        projeto.setDescription(description);
        projetoRepository.save(projeto);
    }

    public void deletar(Long id) {
        Projeto projeto = projetoRepository.getReferenceById(id);
        projetoRepository.delete(projeto);
    }
}
