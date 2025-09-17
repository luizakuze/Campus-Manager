package br.edu.ifsc.db.campusmanager.repository;

import br.edu.ifsc.db.campusmanager.entity.Curso;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CursoRepository extends CrudRepository<Curso, String> {

    List<Curso> findByNomeContainingIgnoreCase(String nomeLike);

    List<Curso> findByPrazoConclusaoLessThanEqual(Integer maxSemestres);

    /* Cursos exigindo ao menos X créditos para formar */
    List<Curso> findByMinCreditosGreaterThanEqual(Integer creditos);
}
