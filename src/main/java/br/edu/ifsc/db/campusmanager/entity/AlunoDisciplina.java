package br.edu.ifsc.db.campusmanager.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Representa o histórico de um aluno em uma disciplina cursada
 * em determinado ano e semestre.
 *
 * <p><b>Tabela:</b> Aluno_Disciplina</p>
 *
 * <p><b>Chave primária composta:</b></p>
 * <ul>
 *   <li>login</li>
 *   <li>codigoDisciplina</li>
 *   <li>ano</li>
 *   <li>semestre</li>
 * </ul>
 *
 * <p><b>Campos adicionais:</b></p>
 * <ul>
 *   <li>conceitoFinal — nota ou conceito final obtido pelo aluno (pode ser nulo)</li>
 * </ul>
 *
 *
 * <p><b>Relações:</b></p>
 * <ul>
 *   <li><b>aluno</b> — relação N:1, indicando que muitos registros de {@code AlunoDisciplina} podem estar associados ao mesmo {@link Aluno}. Isso representa que um aluno pode ter várias disciplinas no seu histórico.</li>
 *   <li><b>disciplina</b> — relação N:1, indicando que muitos registros de {@code AlunoDisciplina} podem referenciar a mesma {@link Disciplina}. Ou seja, uma disciplina pode ser cursada por vários alunos diferentes.</li>
 * </ul>

 * <p><b>Notas técnicas:</b></p>
 * <ul>
 *   <li>A chave composta é representada por uma classe estática interna {@code AlunoDisciplinaCompositeKey}, anotada com {@code @IdClass}</li>
 *   <li>As anotações {@code insertable = false, updatable = false} são utilizadas para manter a consistência com a chave composta nas relações</li>
 * </ul>
 *
 * @see Aluno
 * @see Disciplina
 */

@Entity
@Table(name = "Aluno_Disciplina")
@IdClass(AlunoDisciplina.AlunoDisciplinaCompositeKey.class)
public class AlunoDisciplina {

    /* ----- Composite Key ----- */
    public static class AlunoDisciplinaCompositeKey implements Serializable {
        private String login;
        private String codigoDisciplina;
        private Short  ano;
        private Byte   semestre;

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof AlunoDisciplinaCompositeKey that)) return false;
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

    private Byte conceitoFinal;          // nullable

    /* Relações */
    // insertable + updatable: garante que não haja sobreposição na hora de editar o login/codigoDisciplina
    // outros atributos já fazem isso...

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "login", insertable = false, updatable = false)
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigoDisciplina", insertable = false, updatable = false)
    private Disciplina disciplina;

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

    public Byte getConceitoFinal() {
        return conceitoFinal;
    }

    public void setConceitoFinal(Byte conceitoFinal) {
        this.conceitoFinal = conceitoFinal;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
