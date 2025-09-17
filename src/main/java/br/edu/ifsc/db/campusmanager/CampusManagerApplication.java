package br.edu.ifsc.db.campusmanager;

import br.edu.ifsc.db.campusmanager.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 Classe Principal
 */
@SpringBootApplication
public class CampusManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusManagerApplication.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner demo(AlunoRepository alunoRepo,
                           DisciplinaRepository discRepo,
                           ProfessorDisciplinaRepository profDiscRepo,
                           CursoRepository cursoRepo,
                           ProfessorRepository profRepo,
                           AlunoDisciplinaRepository histRepo,
                           CursoDisciplinaRepository cursoDiscRepo,
                           PessoaRepository pessoaRepo) {

        return args -> {

            /* -------------------------------------------------- */
            System.out.println("\n----------------- CONSULTAS PERSONALIZADAS -----------------\n");

            /* Alunos com IA ≥ 7.0 - ordenado por nome */
            System.out.println("Alunos (IA ≥ 7.0):");
            System.out.printf(" %-30s | %s%n", "Nome", "IA");
            System.out.println("------------------------------------------------------------");
            alunoRepo.findByIndiceAcademicoGreaterThanEqualOrderByNome(new BigDecimal("7.0"))
                    .forEach(a -> System.out.printf(" %-30s | %4.2f%n",
                            a.getNome(), a.getIndiceAcademico()));

            System.out.println("\nDisciplinas concluídas do aluno 'Felipe Eduardo':");
            System.out.println("------------------------------------------------------------");
            histRepo.findDistinctByAlunoNomeAndConceitoFinalIsNotNull("Felipe Eduardo")
                    .forEach(ad -> System.out.println("  - " + ad.getDisciplina().getNome()));

            System.out.println("\nProfessores (título contém “Mestre”):");
            System.out.printf(" %-30s | %s%n", "Nome", "Formação");
            System.out.println("------------------------------------------------------------");
            profRepo.findByFormacaoContainingIgnoreCase("Mestre")
                    .forEach(p -> System.out.printf(" %-30s | %s%n",
                            p.getNome(), p.getFormacao()));

            System.out.println("\nCursos cadastrados:");
            System.out.printf(" %-10s | %-40s%n", "Código", "Nome");
            System.out.println("------------------------------------------------------------");
            cursoRepo.findAll()
                    .forEach(c -> System.out.printf(" %-10s | %-40s%n",
                            c.getCodigoCurso(), c.getNome()));

            /* -------------------------------------------------- */
            System.out.println("\n-------------------- TABELAS COMPLETAS ---------------------\n");

            /* Pessoas */
            System.out.println("\nPESSOAS");
            System.out.println("------------------------------------------------------------");
            System.out.printf(" %-15s | %-25s | %-10s%n", "Login", "Nome", "Status");
            System.out.println("------------------------------------------------------------");
            pessoaRepo.findAll().forEach(p -> System.out.printf(
                    " %-15s | %-25s | %-10s%n",
                    p.getLogin(), p.getNome(), p.getStatus()));

            /* Cursos */
            System.out.println("\nCURSOS");
            System.out.println("------------------------------------------------------------");
            cursoRepo.findAll().forEach(c -> {
                System.out.printf(" - [%s] %-30s | Créditos: %-3d | Prazo: %d%n",
                        c.getCodigoCurso(), c.getNome(),
                        c.getMinCreditos(), c.getPrazoConclusao());
                cursoDiscRepo.findByCursoCodigoCurso(c.getCodigoCurso())
                        .forEach(cd -> System.out.printf("      - Disciplina: %-40s%n",
                                cd.getDisciplina().getNome()));
            });

            /* Disciplinas */
            System.out.println("\nDISCIPLINAS");
            System.out.println("------------------------------------------------------------");
            System.out.printf(" %-10s | %-40s | %s%n", "Código", "Nome", "Créditos");
            System.out.println("------------------------------------------------------------");
            discRepo.findAll().forEach(d -> System.out.printf(
                    " %-10s | %-40s | %2d%n",
                    d.getCodigoDisciplina(), d.getNome(), d.getCreditos()));

            /* Professores */
            System.out.println("\nPROFESSORES");
            System.out.println("------------------------------------------------------------");
            profRepo.findAll().forEach(p -> {
                System.out.printf("\n - %-5s | Formação: %-25s%n", p.getNome(), p.getFormacao());
                profDiscRepo.findByProfessorLogin(p.getLogin())
                        .forEach(pd -> System.out.printf("      - Ministra: %-40s [%d/%d]%n",
                                pd.getDisciplina().getNome(), pd.getAno(), pd.getSemestre()));
            });

            /* Relacionamento Professor-Disciplina */
            System.out.println("\nRELACIONAMENTO PROFESSOR-DISCIPLINA");
            System.out.println("------------------------------------------------------------");
            System.out.printf(" %-30s | %-35s | %s%n", "Professor", "Disciplina", "Ano/Semestre");
            System.out.println("------------------------------------------------------------");
            profDiscRepo.findAll().forEach(pd -> System.out.printf(
                    " %-30s | %-35s | %d/%d%n",
                    pd.getProfessor().getNome(),
                    pd.getDisciplina().getNome(),
                    pd.getAno(),
                    pd.getSemestre()));

            /* Alunos */
            System.out.println("\nALUNOS");
            System.out.println("------------------------------------------------------------");
            alunoRepo.findAll().forEach(a -> {
                System.out.printf(" - %-30s | Matrícula: %-7d | IA: %-4.2f | Status: %s%n",
                        a.getNome(), a.getMatricula(),
                        a.getIndiceAcademico(), a.getStatusConclusao());
                if (a.getCurso() != null) {
                    System.out.println("     Curso: " + a.getCurso().getCodigoCurso());
                }
                histRepo.findByAlunoLogin(a.getLogin())
                        .forEach(ad -> System.out.printf(
                                "      - Disciplina: %-40s (Ano: %4d, Semestre: %d, Conceito: %-5s)%n",
                                ad.getDisciplina().getNome(),
                                ad.getAno(),
                                ad.getSemestre(),
                                ad.getConceitoFinal() == null ? "NULL" : ad.getConceitoFinal()));
            });

            /* Relacionamento Aluno-Disciplina (Histórico) */
            System.out.println("\nRELACIONAMENTO ALUNO-DISCIPLINA");
            System.out.println("------------------------------------------------------------");
            System.out.printf(" %-30s | %-35s | %s%n", "Aluno", "Disciplina", "Ano/Semestre (Conceito)");
            System.out.println("------------------------------------------------------------");
            histRepo.findAll().forEach(ad -> System.out.printf(
                    " %-30s | %-35s | %4d/%d (Conceito: %s)%n",
                    ad.getAluno().getNome(),
                    ad.getDisciplina().getNome(),
                    ad.getAno(),
                    ad.getSemestre(),
                    ad.getConceitoFinal()));

            /* Relacionamento Curso-Disciplina */
            System.out.println("\nRELACIONAMENTO CURSO-DISCIPLINA");
            System.out.println("------------------------------------------------------------");
            System.out.printf(" %-30s | %-35s | %s%n", "Curso", "Disciplina", "PPC");
            System.out.println("------------------------------------------------------------");
            cursoDiscRepo.findAll().forEach(cd -> System.out.printf(
                    " %-30s | %-35s | %d%n",
                    cd.getCurso().getNome(),
                    cd.getDisciplina().getNome(),
                    cd.getCodigoPPC()));
        };
    }
}
