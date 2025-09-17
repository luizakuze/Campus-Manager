package br.edu.ifsc.db.campusmanager.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Entidade de junção entre {@link Curso} e {@link Disciplina}, contendo informações
 * do Projeto Pedagógico de Curso (PPC) associadas a essa combinação.
 *
 * <p><b>Tabela:</b> Curso_Disciplina</p>
 *
 * <p><b>Chave primária composta:</b></p>
 * <ul>
 *   <li>codigoCurso -  código do curso</li>
 *   <li>codigoDisciplina - código da disciplina</li>
 *   <li>codigoPPC- versão do projeto pedagógico</li>
 * </ul>
 *
 * <p><b>Campos adicionais:</b></p>
 * <ul>
 *   <li><b>ementa</b> - descrição da ementa da disciplina no contexto do curso</li>
 *   <li><b>objetivos</b> -  objetivos pedagógicos da disciplina no curso</li>
 * </ul>
 *
 *
 * <p><b>Relações:</b></p>
 * <ul>
 *   <li><b>curso</b> — relação N:1, indicando que vários registros de {@code CursoDisciplina} podem estar vinculados ao mesmo {@link Curso}. Ou seja, um curso pode conter várias disciplinas em seu currículo.</li>
 *   <li><b>disciplina</b> — relação N:1, indicando que vários registros de {@code CursoDisciplina} podem referenciar a mesma {@link Disciplina}. Isso significa que uma mesma disciplina pode ser oferecida por diferentes cursos.</li>
 * </ul>

 *
 * <p><b>Notas técnicas:</b></p>
 * <ul>
 *   <li>A chave composta é definida pela classe interna {@code CursoDisciplinaCompositeKey} com anotação {@code @IdClass}</li>
 *   <li>As anotações {@code insertable = false, updatable = false} nas relações indicam que os valores das chaves já são controlados pelos campos primitivos</li>
 * </ul>
 *
 * @see Curso
 * @see Disciplina
 */

@Entity
@Table(name = "Curso_Disciplina")
@IdClass(CursoDisciplina.CursoDisciplinaCompositeKey.class)
public class CursoDisciplina {

    /* ----- Composite Key ----- */
    public static class CursoDisciplinaCompositeKey implements Serializable {
        private String codigoCurso;
        private String codigoDisciplina;
        private Integer codigoPPC;

        /* equals/hashCode obrigatórios */
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CursoDisciplinaCompositeKey that)) return false;
            return Objects.equals(codigoCurso, that.codigoCurso) &&
                    Objects.equals(codigoDisciplina, that.codigoDisciplina) &&
                    Objects.equals(codigoPPC, that.codigoPPC);
        }
        @Override public int hashCode() {
            return Objects.hash(codigoCurso, codigoDisciplina, codigoPPC);
        }
    }
    /* ----- FKs / PKs ----- */
    @Id @Column(length = 10)
    private String codigoCurso;
    @Id @Column(length = 20)
    private String codigoDisciplina;
    @Id
    private Integer codigoPPC;

    private String ementa;
    private String objetivos;

    /* N:1 para cada lado */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigoCurso", insertable = false, updatable = false)
    private Curso curso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigoDisciplina", insertable = false, updatable = false)
    private Disciplina disciplina;

    /* getters & setters … */

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public Integer getCodigoPPC() {
        return codigoPPC;
    }

    public void setCodigoPPC(Integer codigoPPC) {
        this.codigoPPC = codigoPPC;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
