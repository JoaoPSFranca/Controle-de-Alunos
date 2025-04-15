DROP DATABASE IF EXISTS controleAluno;
CREATE DATABASE controleAluno;
USE controleAluno;

CREATE TABLE horario (
	horario_id INT NOT NULL AUTO_INCREMENT,
    horario_inicio TIME NOT NULL,
    horario_fim TIME NOT NULL,
    horario_periodo ENUM('matutino', 'vespertino', 'noturno') NOT NULL,
    PRIMARY KEY (horario_id)
);

CREATE TABLE turma (
	turma_id INT NOT NULL AUTO_INCREMENT,
    turma_sigla VARCHAR(20) NOT NULL,
    turma_ano YEAR NOT NULL,
    PRIMARY KEY (turma_id)
);

CREATE TABLE aluno (
	aluno_id INT NOT NULL AUTO_INCREMENT,
    turma_id INT NOT NULL,
    aluno_nome VARCHAR(100) NOT NULL,
    aluno_data_nascimento DATE NOT NULL,
    aluno_maioridade TINYINT(1) DEFAULT '0',
    aluno_permissao ENUM('total', 'parcial', 'negada') DEFAULT 'negada',
    PRIMARY KEY (aluno_id),
    FOREIGN KEY (turma_id) REFERENCES turma (turma_id)
);

CREATE TABLE aluno_permissoes (
	permissao_id INT NOT NULL,
    aluno_id INT NOT NULL,
    horario_permitido TIME NOT NULL,
    PRIMARY KEY (permissao_id, aluno_id),
    FOREIGN KEY (aluno_id) REFERENCES aluno (aluno_id)
);

CREATE TABLE responsavel (
	responsavel_id INT NOT NULL AUTO_INCREMENT,
    aluno_id INT NOT NULL,
    responsavel_nome VARCHAR(100) NOT NULL,
    responsavel_data_nascimento DATE NOT NULL,
    PRIMARY KEY (responsavel_id),
    FOREIGN KEY (aluno_id) REFERENCES aluno (aluno_id)
);

CREATE TABLE grade (
	grade_dia ENUM('segunda', 'terca', 'quarta', 'quinta', 'sexta') NOT NULL,
    horario_id INT NOT NULL,
    turma_id INT NOT NULL,
    PRIMARY KEY (grade_dia, horario_id, turma_id),
    FOREIGN KEY (horario_id) REFERENCES horario (horario_id),
    FOREIGN KEY (turma_id) REFERENCES turma (turma_id)
);

CREATE TABLE relatorio (
	relatorio_id INT NOT NULL,
    aluno_id INT NOT NULL,
    relatorio_data DATE NOT NULL,
    relatorio_horario TIME NOT NULL,
    responsavel_id INT,
    relatorio_motivo TEXT,
    relatorio_documento TEXT,
    PRIMARY KEY (relatorio_id),
    FOREIGN KEY (aluno_id) REFERENCES aluno (aluno_id),
    FOREIGN KEY (responsavel_id) REFERENCES responsavel (responsavel_id)
);