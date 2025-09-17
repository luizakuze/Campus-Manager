package br.edu.ifsc.db.campusmanager.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Representa uma pessoa da instituição, como base para Aluno ou Professor.
 *
 * <p>
 * Esta é uma entidade base no modelo de herança da JPA com estratégia JOINED,
 * ou seja, os dados comuns a todas as pessoas (como login, nome, senha e status)
 * são armazenados nesta tabela, enquanto os dados específicos ficam em tabelas filhas
 * como Aluno e Professor.
 * </p>
 *
 * <p><b>Tabela:</b> Pessoa</p>
 *
 * <p><b>Chave Primária:</b> login</p>
 *
 * <p><b>Campos:</b></p>
 * <ul>
 *   <li>login - identificador único da pessoa (PK)</li>
 *   <li>nome - nome completo da pessoa</li>
 *   <li>hashSenha - senha criptografada</li>
 *   <li>status - status da conta (ativo, inativo, etc.)</li>
 * </ul>
 *
 * <p><b>Relações:</b></p>
 * <ul>
 *   <li>Herança com as entidades Aluno e Professor</li>
 * </ul>
 *
 * <p><b>Overrides:</b> equals() e hashCode() com base no campo login</p>
 *
 * @see Aluno
 * @see Professor
 */

@Entity
@Table(name = "Pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

    @Id
    @Column(length = 50)     // PK
    private String login;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(name = "hashSenha", length = 255, nullable = false)
    private String hashSenha;

    @Column(length = 20, nullable = false)
    private String status;

    /* ===== getters & setters ===== */
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getHashSenha() { return hashSenha; }
    public void setHashSenha(String hashSenha) { this.hashSenha = hashSenha; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    /* equals/hashCode -> por login */
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa that)) return false;
        return Objects.equals(login, that.login);
    }
    @Override public int hashCode() { return Objects.hash(login); }


}
