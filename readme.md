# Campus Manager 🏛️📚

Sistema de gerenciamento acadêmico que simula o controle de cursos, disciplinas, alunos e professores de uma instituição de ensino superior.

## Estrutura do Projeto

O banco de dados é composto pelas seguintes entidades:

- **Pessoa**
- **Aluno**
- **Professor**
- **Curso**
- **Disciplina**

E os seus relacionamentos:

- **Curso_Disciplina**  
- **Aluno_Disciplina**  
- **Professor_Disciplina**  


## Como executar

```bash
# Container do banco MySQL
docker-compose up -d

# Acesse o terminal do banco
docker exec -it meumysql mysql -u root -psenhaRoot

# Em outro terminal, execute o script de criação e povoamento do banco
docker exec -i meumysql mysql -u root -psenhaRoot bcd < script.sql

# Pronto! Retorne ao terminal do banco e sua base está pronta 🚀
```