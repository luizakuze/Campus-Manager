package br.edu.ifsc.db.campusmanager.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Representa uma turma de disciplina ministrada por um professor
 * em um determinado ano e semestre letivo.
 *
 * <p><b>Tabela:</b> Professor_Disciplina</p>
 *
 * <p><b>Chave primária composta:</b></p>
 * <ul>
 *   <li>login — identificador do professor (referência para {@link Professor})</li>
 *   <li>codigoDisciplina — código da disciplina ministrada</li>
 *   <li>ano — ano em que a disciplina foi ofertada</li>
 *   <li>semestre — semestre correspondente (1 ou 2)</li>
 * </ul>
 *
 * <p><b>Campos adicionais:</b></p>
 * <ul>
 *   <li><b>bibliografia</b> — bibliografia utilizada na disciplina</li>
 *   <li><b>criterioAvaliacao</b> — critérios usados para avaliação dos alunos</li>
 * </ul>
 *
 * <p><b>Relações:</b></p>
 * <ul>
 *   <li><b>professor</b> — relação N:1, indicando que muitos registros de {@code ProfessorDisciplina} podem estar associados ao mesmo {@link Professor}. Ou seja, um professor pode ministrar várias disciplinas em diferentes períodos.</li>
 *   <li><b>disciplina</b> — relação N:1, indicando que muitos registros de {@code ProfessorDisciplina} podem estar vinculados à mesma {@link Disciplina}. Isso significa que uma disciplina pode ser lecionada por diferentes professores ao longo do tempo.</li>
 * </ul>
 *
 * <p><b>Notas técnicas:</b></p>
 * <ul>
 *   <li>A chave composta é definida pela classe estática {@code ProfessorDisciplinaCompositeKey} com uso de {@code @IdClass}</li>
 *   <li>As anotações {@code insertable = false, updatable = false} nas relações evitam conflito com os campos primitivos</li>
 * </ul>
 *
 * @see Professor
 * @see Disciplina
 */
@Entity
@Table(name = "Professor_Disciplina")
@IdClass(ProfessorDisciplina.ProfessorDisciplinaCompositeKey.class)
public class ProfessorDisciplina {

    /* ----- Composite Key ----- */
    public static class ProfessorDisciplinaCompositeKey implements Serializable {
        private String login;
        private String codigoDisciplina;
        private Short  ano;
        private Byte   semestre;

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ProfessorDisciplinaCompositeKey that)) return false;
            return Objects.equals(login, that.login) &&
                    Objects.equals(codigoDisciplina, that.codigoDisciplina) &&
                    Objects.equals(ano, that.ano) &&
                    Objects.equals(semestre, that.semestre);
        }
        @Override public int hashCode() { return Objects.hash(login, codigoDisciplina, ano, semestre); }
    }

    @Id @Column(length = 50)
    private String login;
    @Id @Column(length = 20)
    private String codigoDisciplina;
    @Id
    private Short ano;
    @Id
    private Byte  semestre;

    /* Dados extras */
    private String bibliografia;
    private String criterioAvaliacao;

    /* Relações */
    // "Não preciso do login dessa tabela... Já tenho esse atributo"...
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "login", insertable = false, updatable = false)
    private Professor professor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigoDisciplina", insertable = false, updatable = false)
    private Disciplina disciplina;

    /* getters & setters … */

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public Short getAno() {
        return ano;
    }

    public void setAno(Short ano) {
        this.ano = ano;
    }

    public Byte getSemestre() {
        return semestre;
    }

    public void setSemestre(Byte semestre) {
        this.semestre = semestre;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    public String getCriterioAvaliacao() {
        return criterioAvaliacao;
    }

    public void setCriterioAvaliacao(String criterioAvaliacao) {
        this.criterioAvaliacao = criterioAvaliacao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
