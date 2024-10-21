package br.com.atividade03.repositories;

import br.com.atividade03.models.Funcionario;
import br.com.atividade03.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query("""
            SELECT p FROM projetos p
            JOIN FETCH p.funcionariosDoProjeto f WHERE f.id = :id
            """)
    List<Projeto> findProjetosDoFuncionarioComBaseNoSeuID(@Param("id") Long id);
}
