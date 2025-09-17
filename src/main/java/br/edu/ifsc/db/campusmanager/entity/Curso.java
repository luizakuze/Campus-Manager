package br.edu.ifsc.db.campusmanager.entity;

import jakarta.persistence.*;
import java.util.List;

/**
 * Representa um curso da instituição (ex.: Engenharia, Administração).
 *
 * <p><b>Tabela:</b> Curso</p>
 *
 * <p><b>Chave Primária:</b> codigoCurso</p>
 *
 * <p><b>Campos:</b></p>
 * <ul>
 *   <li><b>codigoCurso</b>: identificador único do curso</li>
 *   <li><b>nome</b>: nome do curso</li>
 *   <li><b>descricao</b>: descrição geral do curso</li>
 *   <li><b>prazoConclusao</b>: prazo estimado para conclusão (em semestres ou anos, dependendo do sistema)</li>
 *   <li><b>minCreditos</b>: número mínimo de créditos para formar-se no curso</li>
 * </ul>
 *
 * <p><b>Relações:</b></p>
 * <ul>
 *   <li><b>alunos</b> - relação 1:N com {@link Aluno}, representando os alunos matriculados no curso</li>
 *   <li><b>ementas</b> - relação 1:N com {@link CursoDisciplina}, representando as disciplinas vinculadas ao curso (via PPC)</li>
 * </ul>
 *
 * @see Aluno
 * @see CursoDisciplina
 */
@Entity
@Table(name = "Curso")
public class Curso {

    @Id
    @Column(length = 10)
    private String codigoCurso;

    private Integer minCreditos;
    private String descricao;
    private Integer prazoConclusao;

    @Column(length = 100, nullable = false)
    private String nome;

    /* N Aluno */
    @OneToMany(mappedBy = "curso")
    private List<Aluno> alunos;

    /* N CursoDisciplina */
    @OneToMany(mappedBy = "curso")
    private List<CursoDisciplina> ementas;


    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Integer getMinCreditos() {
        return minCreditos;
    }

    public void setMinCreditos(Integer minCreditos) {
        this.minCreditos = minCreditos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPrazoConclusao() {
        return prazoConclusao;
    }

    public void setPrazoConclusao(Integer prazoConclusao) {
        this.prazoConclusao = prazoConclusao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<CursoDisciplina> getEmentas() {
        return ementas;
    }

    public void setEmentas(List<CursoDisciplina> ementas) {
        this.ementas = ementas;
    }
}
