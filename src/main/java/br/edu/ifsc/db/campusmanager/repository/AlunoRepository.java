package br.edu.ifsc.db.campusmanager.repository;

import br.edu.ifsc.db.campusmanager.entity.Aluno;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AlunoRepository extends CrudRepository<Aluno, String> {

    Aluno findByMatricula(Integer matricula);

    /* Top-N pelos melhores índices acadêmicos */
    List<Aluno> findTop10ByOrderByIndiceAcademicoDesc();

    /* Todos de um curso específico e com status X */
    List<Aluno> findByCursoCodigoCursoAndStatusConclusao(String codigoCurso, String statusConclusao);

    /* Todos os alunos com IA > X */
    List<Aluno> findByIndiceAcademicoGreaterThanEqualOrderByNome(BigDecimal minimoIa);

}
