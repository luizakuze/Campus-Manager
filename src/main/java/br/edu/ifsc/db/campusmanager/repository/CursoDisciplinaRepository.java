package br.edu.ifsc.db.campusmanager.repository;

import br.edu.ifsc.db.campusmanager.entity.CursoDisciplina;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CursoDisciplinaRepository extends
        CrudRepository<CursoDisciplina, CursoDisciplina.CursoDisciplinaCompositeKey> {

    /* Todas as ementas de um curso + PPC específico */
    List<CursoDisciplina> findByCodigoCursoAndCodigoPPC(String codigoCurso, Integer codigoPPC);

    /* Disciplinas que fazem parte de vários PPCs de um curso */
    List<CursoDisciplina> findByCodigoCursoAndDisciplinaCodigoDisciplina(String curso, String disciplina);

    List<CursoDisciplina> findByCursoCodigoCurso(String codigoCurso);
}
