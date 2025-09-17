package br.edu.ifsc.db.campusmanager.repository;

import br.edu.ifsc.db.campusmanager.entity.Disciplina;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DisciplinaRepository extends CrudRepository<Disciplina, String> {

    /* verifica disciplina por fase e creditos*/
    List<Disciplina> findByFaseAndCreditosGreaterThan(Byte fase, Integer creditos);

    /*  disciplinas de X fase em UM curso específico */
    List<Disciplina> findDistinctByFaseAndCursosCodigoCurso(Byte fase, String codigoCurso);

}
