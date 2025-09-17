package br.edu.ifsc.db.campusmanager.repository;

import br.edu.ifsc.db.campusmanager.entity.ProfessorDisciplina;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProfessorDisciplinaRepository extends
        CrudRepository<ProfessorDisciplina, ProfessorDisciplina.ProfessorDisciplinaCompositeKey> {

    List<ProfessorDisciplina> findByAnoAndSemestre(Short ano, Byte semestre);

    List<ProfessorDisciplina> findByProfessorLogin(String login);

    List<ProfessorDisciplina> findByDisciplinaCodigoDisciplina(String codigoDisciplina);
}
