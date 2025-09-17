package br.edu.ifsc.db.campusmanager.entity;

import jakarta.persistence.*;
import java.util.List;

/**
 * Representa um professor da instituição, estendendo a entidade {@link Pessoa}.
 *
 * <p>
 * Cada professor herda os dados básicos de pessoa (como login, nome, senha e status),
 * e possui informações específicas como identificação interna e formação acadêmica.
 * </p>
 *
 * <p><b>Tabela:</b> Professor</p>
 *
 * <p><b>Chave Primária:</b> login (herdada de {@link Pessoa})</p>
 *
 * <p><b>Campos adicionais:</b></p>
 * <ul>
 *   <li><b>idProf</b> — identificador interno único do professor no sistema</li>
 *   <li><b>formacao</b> — formação acadêmica do professor (ex.: Mestrado em Computação)</li>
 * </ul>
 *
 *
 * <p><b>Relações:</b></p>
 * <ul>
 *   <li><b>turmas</b> - relação 1:N, indicando que um único {@link Professor} pode ministrar várias disciplinas ao longo do tempo, registradas em diferentes períodos na entidade {@code ProfessorDisciplina}.</li>
 * </ul>

 *
 * @see Pessoa
 * @see ProfessorDisciplina
 */

@Entity
@Table(name = "Professor")
@PrimaryKeyJoinColumn(name = "login")
public class Professor extends Pessoa {

    // atributo existente pois era pré requisito!
    @Column(nullable = false)
    private Integer idProf;

    @Column(length = 255)
    private String formacao;

    /* 1 professor -> N ProfessorDisciplina */
    @OneToMany(mappedBy = "professor", fetch = FetchType.EAGER)
    private List<ProfessorDisciplina> turmas;

    /* getters & setters … */
    public Integer getIdProf() { return idProf; }
    public void setIdProf(Integer idProf) { this.idProf = idProf; }

    public String getFormacao() { return formacao; }
    public void setFormacao(String formacao) { this.formacao = formacao; }

    public List<ProfessorDisciplina> getTurmas() { return turmas; }
    public void setTurmas(List<ProfessorDisciplina> turmas) { this.turmas = turmas; }


}
