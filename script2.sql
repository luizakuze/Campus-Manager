-- Rename Primary Keys
ALTER TABLE Pessoa RENAME CONSTRAINT `PRIMARY` TO PK_Pessoa;
ALTER TABLE Professor RENAME CONSTRAINT `PRIMARY` TO PK_Professor;
ALTER TABLE Curso RENAME CONSTRAINT `PRIMARY` TO PK_Curso;
ALTER TABLE Disciplina RENAME CONSTRAINT `PRIMARY` TO PK_Disciplina;
ALTER TABLE Aluno RENAME CONSTRAINT `PRIMARY` TO PK_Aluno;
ALTER TABLE Professor_Disciplina RENAME CONSTRAINT `PRIMARY` TO PK_Professor_Disciplina;
ALTER TABLE Curso_Disciplina RENAME CONSTRAINT `PRIMARY` TO PK_Curso_Disciplina;
ALTER TABLE Aluno_Disciplina RENAME CONSTRAINT `PRIMARY` TO PK_Aluno_Disciplina;

-- Rename Foreign Keys
ALTER TABLE Professor RENAME CONSTRAINT professor_ibfk_1 TO FK_Professor_Pessoa;
ALTER TABLE Aluno RENAME CONSTRAINT aluno_ibfk_1 TO FK_Aluno_Pessoa;
ALTER TABLE Aluno RENAME CONSTRAINT aluno_ibfk_2 TO FK_Aluno_Curso;
ALTER TABLE Professor_Disciplina RENAME CONSTRAINT professor_disciplina_ibfk_1 TO FK_ProfessorDisciplina_Professor;
ALTER TABLE Professor_Disciplina RENAME CONSTRAINT professor_disciplina_ibfk_2 TO FK_ProfessorDisciplina_Disciplina;
ALTER TABLE Curso_Disciplina RENAME CONSTRAINT curso_disciplina_ibfk_1 TO FK_CursoDisciplina_Curso;
ALTER TABLE Curso_Disciplina RENAME CONSTRAINT curso_disciplina_ibfk_2 TO FK_CursoDisciplina_Disciplina;
ALTER TABLE Aluno_Disciplina RENAME CONSTRAINT aluno_disciplina_ibfk_1 TO FK_AlunoDisciplina_Aluno;
ALTER TABLE Aluno_Disciplina RENAME CONSTRAINT aluno_disciplina_ibfk_2 TO FK_AlunoDisciplina_Disciplina;
