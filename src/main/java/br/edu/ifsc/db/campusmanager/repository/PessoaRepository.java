package br.edu.ifsc.db.campusmanager.repository;

import br.edu.ifsc.db.campusmanager.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/** Operações para qualquer usuário do sistema */
public interface PessoaRepository extends CrudRepository<Pessoa, String> {

    /* Busca todos pelo status (ativo / inativo) */
    List<Pessoa> findByStatus(String status);

    /* Busca pelo pedaço do nome, ignorando maiúsc./minús. */
    List<Pessoa> findByNomeContainingIgnoreCase(String trecho);
}
