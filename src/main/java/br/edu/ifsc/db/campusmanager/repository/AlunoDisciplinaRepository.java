package br.edu.ifsc.db.campusmanager.repository;

import br.edu.ifsc.db.campusmanager.entity.AlunoDisciplina;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AlunoDisciplinaRepository extends
        CrudRepository<AlunoDisciplina, AlunoDisciplina.AlunoDisciplinaCompositeKey> {

    /* Histórico já concluído de um aluno */
    List<AlunoDisciplina> findByAlunoLoginAndConceitoFinalIsNotNull(String login);

    /* Disciplinas já cursadas por X aluno */
    List<AlunoDisciplina> findDistinctByAlunoNomeAndConceitoFinalIsNotNull(String nomeAluno);

    /* Encontra aluno pelo login */
    List<AlunoDisciplina> findByAlunoLogin(String login);
}
