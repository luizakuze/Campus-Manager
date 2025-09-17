package br.edu.ifsc.db.campusmanager.repository;

import br.edu.ifsc.db.campusmanager.entity.Professor;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProfessorRepository extends CrudRepository<Professor, String> {

    /* por id interno (chave natural) */
    Professor findByIdProf(Integer idProf);

    /* Todos que contenham uma determinada formação */
    List<Professor> findByFormacaoContainingIgnoreCase(String termo);

    /* Professores que já lecionaram uma disciplina específica */
    List<Professor> findDistinctByTurmasDisciplinaCodigoDisciplina(String codigoDisciplina);
}
