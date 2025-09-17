package br.edu.ifsc.db.campusmanager.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Representa um aluno da instituição, estendendo a entidade {@link Pessoa}.
 *
 * <p>
 * Cada aluno herda os atributos básicos da pessoa (como login, nome, senha e status),
 * e adiciona informações acadêmicas específicas.
 * </p>
 *
 * <p><b>Tabela:</b> Aluno</p>
 *
 * <p><b>Chave Primária:</b> login (herdada de Pessoa)</p>
 *
 * <p><b>Campos adicionais:</b></p>
 * <ul>
 *   <li><b>matricula</b>: número de matrícula do aluno</li>
 *   <li><b>indiceAcademico</b>: coeficiente de rendimento acumulado</li>
 *   <li><b>dataInicio</b>: data de ingresso no curso</li>
 *   <li><b>dataFim</b>: data de saída ou conclusão</li>
 *   <li><b>statusConclusao</b>: situação atual no curso (ex: ativo, concluído, trancado)</li>
 * </ul>
 *
 * <p><b>Relações:</b></p>
 * <ul>
 *   <li><b>curso (aluno + curso) </b> (N:1): cada aluno está vinculado a um único curso</li>
 *   <li><b>historico (aluno + disciplina)</b> (1:N): lista de disciplinas cursadas pelo aluno</li>
 * </ul>
 *
 * @see Pessoa
 * @see Curso
 * @see AlunoDisciplina
 */

@Entity
@Table(name = "Aluno")
@PrimaryKeyJoinColumn(name = "login")
public class Aluno extends Pessoa {

    private Integer   matricula;
    private BigDecimal indiceAcademico;

    private LocalDate dataInicio;
    private LocalDate dataFim;

    @Column(length = 20)
    private String statusConclusao;

    /* N:1 Curso, 1 curso pode ter muitos alunos*/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigoCurso", nullable = false)
    private Curso curso;

    /* 1:N  */
    @OneToMany(mappedBy = "aluno")
    private List<AlunoDisciplina> historico;

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public BigDecimal getIndiceAcademico() {
        return indiceAcademico;
    }

    public void setIndiceAcademico(BigDecimal indiceAcademico) {
        this.indiceAcademico = indiceAcademico;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getStatusConclusao() {
        return statusConclusao;
    }

    public void setStatusConclusao(String statusConclusao) {
        this.statusConclusao = statusConclusao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<AlunoDisciplina> getHistorico() {
        return historico;
    }

    public void setHistorico(List<AlunoDisciplina> historico) {
        this.historico = historico;
    }
}
