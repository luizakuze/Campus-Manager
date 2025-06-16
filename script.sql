CREATE TABLE Pessoa (
    login VARCHAR(50),
    nome VARCHAR(100) NOT NULL,
    hashSenha VARCHAR(255) NOT NULL,
    status VARCHAR(20) NOT NULL,
    PRIMARY KEY (login)
);

CREATE TABLE Professor (
    login VARCHAR(50) NOT NULL,
    idProf INT NOT NULL,
    formacao VARCHAR(255),
    PRIMARY KEY (login),
    FOREIGN KEY (login) REFERENCES Pessoa(login)
);

CREATE TABLE Curso (
    codigoCurso VARCHAR(10) NOT NULL,
    minCreditos INT NOT NULL,
    descricao TEXT,
    prazoConclusao INT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY (codigoCurso)
);

CREATE TABLE Disciplina (
    codigoDisciplina VARCHAR(20),
    nome VARCHAR(100) NOT NULL,
    creditos INT NOT NULL,
    descricao TEXT,
    fase TINYINT NOT NULL,
    eixoTematico VARCHAR(50) NOT NULL,
    PRIMARY KEY (codigoDisciplina)
);

CREATE TABLE Aluno (
    login VARCHAR(50) NOT NULL,
    matricula INT NOT NULL,
    indiceAcademico DECIMAL(4,2) NOT NULL,
    dataInicio DATE NOT NULL,
    dataFim DATE,
    statusConclusao VARCHAR(20) NOT NULL,
    codigoCurso VARCHAR(10) NOT NULL,
    PRIMARY KEY (login),
    UNIQUE (matricula),
    FOREIGN KEY (login) REFERENCES Pessoa(login),
    FOREIGN KEY (codigoCurso) REFERENCES Curso(codigoCurso)
);

CREATE TABLE Professor_Leciona_Disciplina (
    login VARCHAR(50) NOT NULL,
    codigoDisciplina VARCHAR(20) NOT NULL,
    ano YEAR NOT NULL,
    semestre TINYINT NOT NULL,
    bibliografia TEXT,
    criterioAvaliacao TEXT,
    PRIMARY KEY (login, codigoDisciplina, ano, semestre),
    FOREIGN KEY (login) REFERENCES Professor(login),
    FOREIGN KEY (codigoDisciplina) REFERENCES Disciplina(codigoDisciplina)
);

CREATE TABLE Curso_Possui_Disciplina (
    codigoCurso VARCHAR(10) NOT NULL,
    codigoDisciplina VARCHAR(20) NOT NULL,
    codigoPPC INT NOT NULL,
    ementa TEXT,
    objetivos TEXT,
    PRIMARY KEY (codigoCurso, codigoDisciplina, codigoPPC),
    FOREIGN KEY (codigoCurso) REFERENCES Curso(codigoCurso),
    FOREIGN KEY (codigoDisciplina) REFERENCES Disciplina(codigoDisciplina)
);

CREATE TABLE Aluno_Cursa_Disciplina (
    login VARCHAR(50) NOT NULL,
    codigoDisciplina VARCHAR(20) NOT NULL,
    ano YEAR NOT NULL,
    semestre TINYINT NOT NULL,
    conceitoFinal TINYINT,
    PRIMARY KEY (login, codigoDisciplina, ano, semestre),
    FOREIGN KEY (login) REFERENCES Aluno(login),
    FOREIGN KEY (codigoDisciplina) REFERENCES Disciplina(codigoDisciplina)
);

-- Criando disciplinas
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('ESC129001', 'Engenharia, Sociedade e Cidadania', 2, 'Impactos sociais da engenharia',   1, 'A depender da UC');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('CAL129001', 'Cálculo I', 6, 'Funções e limites',   1, 'Básico');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('PTG129001', 'Comunicação e Expressão', 2, 'Leitura, escrita e expressão técnica',   1, 'Outros');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('GEA129001', 'Geometria Analítica', 3, 'Disciplina de geometria analítica.',   1, 'Básico');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('PRG129001', 'Programação I', 4, 'Algoritmos e lógica de programação',   2, 'Desenvolvimento de Software');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('PJI129001', 'Projeto Integrador I', 4, 'Integração de conhecimentos iniciais',   2, 'Projeto de Sistemas');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('DES129002', 'Desenho Técnico', 2, 'Desenho técnico aplicado à engenharia',   2, 'Outros');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('CAL129002', 'Cálculo II', 4, 'Integrais e aplicações',   2, 'Básico');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('FSC129002', 'Física I', 4, 'Mecânica e termologia',   2, 'Básico');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('ALG129002', 'Álgebra Linear', 3, 'Vetores, matrizes e autovalores',   3, 'Outros');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('ELD129002', 'Eletrônica Digital I', 4, 'Portas lógicas e flip-flops',   3, 'Eletroeletrônica');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('PRG129002', 'Programação II', 4, 'Programação estruturada',   3, 'Desenvolvimento de Software');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('POO129003', 'Programação Orientada a Objetos', 4, 'POO em linguagens modernas',   3, 'Desenvolvimento de Software');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('CIE129003', 'Circuitos Elétricos I', 4, 'Teoria básica de circuitos',   3, 'Eletroeletrônica');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('MEC129003', 'Mecânica dos Sólidos', 2, 'Tensões, deformações e esforços',   4, 'Outros');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('CAL129003', 'Sequências e Séries', 2, 'Séries e sequências numéricas',   4, 'Básico');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('FSC129003', 'Física III', 4, 'Ondas e ótica',   4, 'Básico');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('CAN129003', 'Cálculo Numérico', 2, 'Métodos numéricos computacionais',   4, 'Básico');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('ADM129004', 'Administração para Engenharia', 2, 'Administração aplicada',   4, 'A depender da UC');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('CAL129004', 'Cálculo III', 4, 'Multivariáveis',   5, 'Básico');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('FSC129004', 'Física II', 4, 'Eletromagnetismo',   5, 'Básico');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('EEP129004', 'Estatística e Probabilidade', 3, 'Modelagem e inferência estatística',   5, 'Básico');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('AOC129004', 'Arquitetura e Organização de Computadores', 4, 'Hardware e CPU',   5, 'Desenvolvimento de Software');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('SIS129004', 'Sinais e Sistemas', 5, 'Análise de sinais contínuos e discretos',   5, 'Comunicação e Processamento de Sinais');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('FEN129005', 'Fenômenos de Transporte', 2, 'Transferência de calor e massa',   6, 'Outros');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('CIE129005', 'Circuitos Elétricos II', 3, 'AC, transientes e fasores',   6, 'Eletroeletrônica');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('EMG129005', 'Eletromagnetismo', 4, 'Campos elétricos e magnéticos',   6, 'Eletroeletrônica');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('LCI129005', 'Laboratório de Circuitos Elétricos', 2, 'Disciplina de laboratório de circuitos elétricos.',   6, 'Eletroeletrônica');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('PSD129005', 'Processamento de Sinais Digitais', 3, 'Transformadas e filtros digitais',   6, 'Comunicação e Processamento de Sinais');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('RED129005', 'Redes de Computadores I', 4, 'Camadas de rede, roteamento',   7, 'Redes de Computadores');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('SOP129005', 'Sistemas Operacionais', 4, 'Gerência de processos e memória',   7, 'Desenvolvimento de Software');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('PJI129006', 'Projeto Integrador II', 4, 'Projeto interdisciplinar em grupo',   7, 'Projeto de Sistemas');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('QMC129006', 'Química Geral', 3, 'Fundamentos de química para engenharia',   7, 'Básico');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('MTG129006', 'Meios de Transmissão Guiados', 4, 'Guias de onda e fibras ópticas',   7, 'Outros');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('ELA129006', 'Eletrônica I', 4, 'Dispositivos semicondutores e circuitos',   8, 'Eletroeletrônica');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('STD129006', 'Sistemas Distribuídos', 3, 'Computação paralela e distribuída',   8, 'Desenvolvimento de Software');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('CTM129007', 'Ciência e Tecnologia dos Materiais', 2, 'Propriedades dos materiais',   8, 'Outros');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('AEX129007', 'Atividades de Extensão I', 2, 'Projeto de extensão com a comunidade',   8, 'A depender da UC');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('ANT129007', 'Antenas e Propagação', 4, 'Modelos de propagação e antenas',   8, 'Sistemas de Telecomunicações');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('ELA129007', 'Eletrônica II', 2, 'Amplificadores e circuitos práticos',   9, 'Eletroeletrônica');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('MIC129007', 'Microcontroladores', 4, 'Sistemas embarcados com microcontroladores',   9, 'Eletroeletrônica');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('ECO129008', 'Economia para Engenharia', 2, 'Avaliação econômica de projetos',   9, 'A depender da UC');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('AEX129008', 'Atividades de Extensão II', 1, 'Ações práticas de extensão',   9, 'A depender da UC');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('CSF129008', 'Comunicações sem Fio', 3, 'Redes móveis e transmissão sem fio',   9, 'Sistemas de Telecomunicações');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('CRF129008', 'Circuitos de Radiofrequência', 4, 'Circuitos de alta frequência',   10, 'Eletroeletrônica');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('STE129008', 'Sistemas Embarcados', 4, 'Hardware e software integrados',   10, 'Outros');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('COM129007', 'Sistemas de Comunicação', 5, 'Modulação e transmissão de sinais',   10, 'Outros');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('PJI129009', 'Projeto Integrador III', 4, 'Projeto avançado de integração',   10, 'Projeto de Sistemas');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('STC129009', 'Sistemas de Telecomunicações', 4, 'Infraestrutura de redes de comunicação',   10, 'Outros');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('MPQ129009', 'Metodologia de Pesquisa', 2, 'Técnicas de pesquisa acadêmica',   10, 'Projeto de Sistemas');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('SEG129010', 'Engenharia e Sustentabilidade', 2, 'Sustentabilidade na prática da engenharia',   10, 'A depender da UC');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('EST129010', 'Estágio', 8, 'Vivência profissional supervisionada',   10, 'Projeto de Sistemas');
INSERT INTO Disciplina (codigoDisciplina, nome, creditos, descricao, fase, eixoTematico) VALUES ('PFC129010', 'Projeto Final de Curso', 7, 'Trabalho de conclusão de curso',   10, 'Outros');



-- Inserção do curso de Engenharia de Telecomunicações
INSERT INTO Curso (codigoCurso, minCreditos, descricao, prazoConclusao, nome)
VALUES (
    'ENG',
    240,
    'Formação sólida em tecnologias de comunicação, redes e sistemas embarcados, preparando engenheiros para projetar, operar e otimizar sistemas de telecomunicações modernos.',
    10,
    'Engenharia de Telecomunicações'
);

-- Inserção do curso de Análise e Desenvolvimento de Sistemas
INSERT INTO Curso (codigoCurso, minCreditos, descricao, prazoConclusao, nome)
VALUES (
    'ADS',
    160,
    'Curso voltado à criação de soluções de software, com foco em análise de requisitos, programação, banco de dados e desenvolvimento de aplicações web e mobile.',
    20,
    'Análise e Desenvolvimento de Sistemas'
);

-- Inserção das disciplinas do curso de Engenharia de Telecomunicações
INSERT INTO Curso_Possui_Disciplina (codigoCurso, codigoDisciplina, codigoPPC, ementa, objetivos)
SELECT 'ENG', codigoDisciplina, 1290, CONCAT('Ementa da disciplina ', nome), CONCAT('Objetivos da disciplina ', nome)
FROM Disciplina;


-- Inserção de usuários do sistema
INSERT INTO Pessoa (login, nome, hashSenha, status) VALUES 
('luiza.kuze', 'Luiza Kuze', 'hash1', 'ativo'),
('helena.sofia', 'Helena Sofia', 'hash2', 'inativo'),
('felipe.eduardo', 'Felipe Eduardo', 'hash3', 'ativo'),
('maria.eduarda', 'Maria Eduarda Silva', 'hashprof1', 'ativo'),
('ana.oliveira', 'Ana Oliveira', 'hashprof2', 'ativo'),
('beatriz.souza', 'Beatriz Souza', 'hashprof3', 'ativo'),
('carolina.pereira', 'Carolina Maria Pereira', 'hashprof4', 'ativo'),
('lucas.gabriel', 'Lucas Gabriel', 'hashprof5', 'ativo'),
('gabriel.silva', 'Gabriel Silva', 'hashprof6', 'ativo'),
('mateus.henrique', 'Mateus Henrique', 'hashprof7', 'ativo'),
('guilherme.augusto', 'Guilherme Augusto', 'hashprof8', 'ativo');


-- Inserção de alunos
INSERT INTO Aluno (login, matricula, indiceAcademico, dataInicio, dataFim, statusConclusao, codigoCurso) VALUES 
('luiza.kuze', 2022100001, 8.75, '2022-03-01', NULL, 'cursando', 'ENG'),
('helena.sofia', 2022100002, 9.1, '2020-03-01', '2025-12-01', 'concluido', 'ENG'),
('felipe.eduardo', 2022100003, 7.8, '2023-03-01', NULL, 'cursando', 'ADS'); 

-- Inserção do professor  
INSERT INTO Professor (login, idProf, formacao) VALUES
('maria.eduarda', 2, 'Mestre em Engenharia'),
('ana.oliveira', 3, 'Doutora em Computação'),
('beatriz.souza', 4, 'Mestre em Física'),
('carolina.pereira', 5, 'Doutora em Matemática'),
('lucas.gabriel', 6, 'Mestre em Sistemas Elétricos'),
('gabriel.silva', 7, 'Mestre em Estatística'),
('mateus.henrique', 8, 'Doutor em Engenharia de Telecomunicações'),
('guilherme.augusto', 9, 'Mestre em Engenharia de Software');


-- Inserção do vínculo de lecionamento de disciplinas
INSERT INTO Professor_Leciona_Disciplina (login, codigoDisciplina, ano, semestre, bibliografia, criterioAvaliacao) VALUES
('maria.eduarda', 'ESC129001', 2022, 1, 'Textos de cidadania', 'Participação e redações'),
('ana.oliveira', 'CAL129001', 2022, 1, 'Guidorizzi Vol.1', 'Provas e listas'),
('beatriz.souza', 'PTG129001', 2022, 2, 'Gramática técnica', 'Trabalhos e presença'),
('carolina.pereira', 'GEA129001', 2022, 2, 'Livros de geometria', 'Listas e prova final'),
('lucas.gabriel', 'PRG129001', 2022, 1, 'Algoritmos em C', 'Projetos em dupla'),
('gabriel.silva', 'PJI129001', 2022, 1, 'Material interdisciplinar', 'Apresentações'),
('mateus.henrique', 'DES129002', 2022, 2, 'Desenho Técnico IFSC', 'Prova gráfica'),
('guilherme.augusto', 'CAL129002', 2022, 2, 'Guidorizzi Vol.2', 'Listas e provas'),
('maria.eduarda', 'FSC129002', 2022, 1, 'Física I - Halliday', 'Provas e experimentos'),
('ana.oliveira', 'ALG129002', 2022, 1, 'Álgebra Linear', 'Listas e prova oral'),
('beatriz.souza', 'ELD129002', 2022, 2, 'Circuitos digitais', 'Simulação e avaliação'),
('carolina.pereira', 'PRG129002', 2022, 2, 'Programação estruturada', 'Desenvolvimento de sistema'),
('lucas.gabriel', 'POO129003', 2023, 1, 'Java e C++', 'Provas e mini-projetos'),
('gabriel.silva', 'CIE129003', 2023, 1, 'Circuitos I', 'Avaliação prática'),
('mateus.henrique', 'MEC129003', 2023, 2, 'Materiais estruturais', 'Prova escrita'),
('guilherme.augusto', 'CAL129003', 2023, 2, 'Guidorizzi Vol.3', 'Provas regulares'),
('maria.eduarda', 'FSC129003', 2023, 1, 'Física III', 'Estudos dirigidos'),
('ana.oliveira', 'CAN129003', 2023, 1, 'Cálculo numérico', 'Implementações'),
('beatriz.souza', 'ADM129004', 2023, 1, 'Administração aplicada', 'Trabalho escrito'),
('carolina.pereira', 'CAL129004', 2023, 2, 'Cálculo Multivariável', 'Listas'),
('lucas.gabriel', 'FSC129004', 2023, 2, 'Eletromagnetismo', 'Provas e simulado'),
('gabriel.silva', 'EEP129004', 2023, 2, 'Estatística', 'Prova final'),
('mateus.henrique', 'AOC129004', 2023, 2, 'Arquitetura de computadores', 'Projeto em grupo'),
('guilherme.augusto', 'SIS129004', 2023, 2, 'Análise de sinais', 'Trabalho final'),
('maria.eduarda', 'FEN129005', 2024, 1, 'Fenômenos térmicos', 'Estudo de caso'),
('ana.oliveira', 'CIE129005', 2024, 1, 'Circuitos II', 'Prova e prática'),
('beatriz.souza', 'EMG129005', 2024, 1, 'Campos Elétricos', 'Prova com consulta'),
('carolina.pereira', 'LCI129005', 2024, 2, 'Experimentos elétricos', 'Relatórios'),
('lucas.gabriel', 'PSD129005', 2024, 2, 'DSP e filtros', 'Mini projeto');

-- Inserção do disciplinas de um aluno
INSERT INTO Aluno_Cursa_Disciplina (login, codigoDisciplina, ano, semestre, conceitoFinal) VALUES
('luiza.kuze', 'ESC129001', 2022, 1, 10),
('luiza.kuze', 'CAL129001', 2022, 1, 9),
('luiza.kuze', 'PTG129001', 2022, 2, 10),
('luiza.kuze', 'GEA129001', 2022, 2, 10),
('luiza.kuze', 'PRG129001', 2022, 1, 9),
('luiza.kuze', 'PJI129001', 2022, 1, 10),
('luiza.kuze', 'DES129002', 2022, 2, 10),
('luiza.kuze', 'CAL129002', 2022, 2, 9),
('luiza.kuze', 'FSC129002', 2022, 1, 8),
('luiza.kuze', 'ALG129002', 2022, 1, 7),
('luiza.kuze', 'ELD129002', 2022, 2, 10),
('luiza.kuze', 'PRG129002', 2022, 2, 10),
('luiza.kuze', 'POO129003', 2023, 1, 9),
('luiza.kuze', 'CIE129003', 2023, 1, 10),
('luiza.kuze', 'MEC129003', 2023, 2, 7),
('luiza.kuze', 'CAL129003', 2023, 2, 8),
('luiza.kuze', 'FSC129003', 2023, 1, 9),
('luiza.kuze', 'CAN129003', 2023, 1, 10),
('luiza.kuze', 'ADM129004', 2023, 1, 10),
('luiza.kuze', 'CAL129004', 2023, 2, 9),
('luiza.kuze', 'FSC129004', 2023, 2, 8),
('luiza.kuze', 'EEP129004', 2023, 2, 8),
('luiza.kuze', 'AOC129004', 2023, 2, 9),
('luiza.kuze', 'SIS129004', 2023, 2, 9),
('luiza.kuze', 'FEN129005', 2024, 1, 10),
('luiza.kuze', 'CIE129005', 2024, 1, 7),
('luiza.kuze', 'EMG129005', 2024, 1, 8),
('luiza.kuze', 'LCI129005', 2024, 2, 9),
('luiza.kuze', 'PSD129005', 2024, 2, 10);