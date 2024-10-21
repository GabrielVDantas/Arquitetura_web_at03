package br.com.atividade03.service;

import br.com.atividade03.dtos.FuncionarioDTO;
import br.com.atividade03.dtos.SetorDTO;
import br.com.atividade03.dtos.queryreqs.RetornaTodosOsSetoresComFuncionariosDTO;
import br.com.atividade03.models.Setor;
import br.com.atividade03.repositories.SetorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorServiceImpl implements SetorService {
    @Autowired
    private SetorRepository setorRepository;

    @Override
    public RetornaTodosOsSetoresComFuncionariosDTO buscaSetorMaisFuncionarios() {
        List<Setor> setoresList = setorRepository.findTodosOsSetoresComFuncionarios();

        List<SetorDTO> setorDTOList = setoresList.stream().map((Setor s) -> {
            List<FuncionarioDTO> funcionarioDTOList = s.getFuncionarios().stream().map(f -> {
                return FuncionarioDTO.builder()
                        .name(f.getName())
                        .build();
            }).toList();
            return SetorDTO.builder()
                    .name(s.getName())
                    .funcionarioDTOList(funcionarioDTOList)
                    .build();
        }).toList();

        return RetornaTodosOsSetoresComFuncionariosDTO.builder()
                .setorDTOList(setorDTOList)
                .build();
    }

    public void adicionar(SetorDTO setorDTO) {
        Setor setor = new Setor(setorDTO.name());
        setorRepository.save(setor);
    }

    public void ver() {
        List<Setor> setores = setorRepository.findAll();
    }

    @Transactional
    public void atualizar(Long id, String name) {
        Setor setor = setorRepository.getReferenceById(id);
        setor.setName(name);
        setorRepository.save(setor);
    }

    public void deletar(Long id) {
        Setor setor = setorRepository.getReferenceById(id);
        setorRepository.delete(setor);
    }
}
