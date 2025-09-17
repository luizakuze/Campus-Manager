package br.edu.ifsc.db.campusmanager.entity;

import jakarta.persistence.*;
import java.util.List;

/**
 * Representa uma disciplina curricular da instituição
 * (exemplos: Cálculo I, Programação Orientada a Objetos).
 *
 * <p><b>Tabela:</b> Disciplina</p>
 *
 * <p><b>Chave Primária:</b> codigoDisciplina</p>
 *
 * <p><b>Campos:</b></p>
 * <ul>
 *   <li><b>codigoDisciplina</b>: identificador único da disciplina</li>
 *   <li><b>nome</b>: nome completo da disciplina</li>
 *   <li><b>creditos</b>: quantidade de créditos atribuída à disciplina</li>
 *   <li><b>descricao</b>: descrição geral do conteúdo</li>
 *   <li><b>fase</b>: período sugerido (ex: 1º semestre, 2º semestre)</li>
 *   <li><b>eixoTematico</b>: área temática à qual a disciplina pertence</li>
 * </ul>
 *
 * <p><b>Relações:</b></p>
 * <ul>
 *   <li><b>cursos</b> — relação 1:N, onde uma disciplina pode ser ofertada em vários {@link Curso}s por meio da entidade {@link CursoDisciplina}</li>
 *   <li><b>turmas</b> — relação 1:N, onde uma disciplina pode ser ministrada por vários professores em diferentes períodos, representados por {@link ProfessorDisciplina}</li>
 *   <li><b>historicos</b> — relação 1:N, onde uma disciplina pode aparecer no histórico de vários alunos, por meio da entidade {@link AlunoDisciplina}</li>
 * </ul>

 *
 * @see CursoDisciplina
 * @see ProfessorDisciplina
 * @see AlunoDisciplina
 */

@Entity
@Table(name = "Disciplina")
public class Disciplina {

    @Id
    @Column(length = 20)
    private String codigoDisciplina;

    @Column(length = 100, nullable = false)
    private String nome;

    private Integer creditos;
    private String  descricao;
    private Byte    fase;

    @Column(length = 50)
    private String eixoTematico;

    /* Relações inversas */
    @OneToMany(mappedBy = "disciplina")
    private List<CursoDisciplina> cursos;
    @OneToMany(mappedBy = "disciplina")
    private List<ProfessorDisciplina> turmas;
    @OneToMany(mappedBy = "disciplina")
    private List<AlunoDisciplina> historicos;

    /* getters & setters … */

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Byte getFase() {
        return fase;
    }

    public void setFase(Byte fase) {
        this.fase = fase;
    }

    public String getEixoTematico() {
        return eixoTematico;
    }

    public void setEixoTematico(String eixoTematico) {
        this.eixoTematico = eixoTematico;
    }

    public List<CursoDisciplina> getCursos() {
        return cursos;
    }

    public void setCursos(List<CursoDisciplina> cursos) {
        this.cursos = cursos;
    }

    public List<ProfessorDisciplina> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<ProfessorDisciplina> turmas) {
        this.turmas = turmas;
    }

    public List<AlunoDisciplina> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<AlunoDisciplina> historicos) {
        this.historicos = historicos;
    }
}
