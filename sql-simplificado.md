# Notação Simplificada SQL

**Pessoa** (<u>login</u>, nome, hashSenha, status)

**Professor** (<u>login</u>, idProf, formacao)  
  <u>login</u> referencia Pessoa

**Curso** (<u>codigoCurso</u>, minCreditos, descricao, prazoConclusao, nome)

**Disciplina** (<u>codigoDisciplina</u>, nome, creditos, descricao)

**Aluno** (<u>login</u>, matricula, indiceAcademico, dataInicio, dataFim, statusConclusao, <u>codigoCurso</u>)  
  <u>login</u> referencia Pessoa  
  <u>codigoCurso</u> referencia Curso

**Professor_Leciona_Disciplina** (idProf, <u>codigoDisciplina</u>, <u>ano</u>, <u>semestre</u>, bibliografia, criterioAvaliacao)  
  idProf referencia Professor  
  <u>codigoDisciplina</u> referencia Disciplina

**Curso_Possui_Disciplina** (<u>codigoCurso</u>, <u>codigoDisciplina</u>, <u>codigoPPC</u>, ementa, objetivos)  
  <u>codigoCurso</u> referencia Curso  
  <u>codigoDisciplina</u> referencia Disciplina

**Aluno_Cursa_Disciplina** (matricula, <u>codigoDisciplina</u>, <u>ano</u>, <u>semestre</u>, conceitoFinal)  
  matricula referencia Aluno  
  <u>codigoDisciplina</u> referencia Disciplina
