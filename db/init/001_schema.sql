/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  lucas
 * Created: Aug 26, 2026
 */

CREATE TABLE diretor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    nacionalidade VARCHAR(100)
);

CREATE TABLE genero (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE filme (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    ano_lancamento INT,
    sinopse TEXT,
    id_diretor INT NOT NULL,
    id_genero INT NOT NULL,
    FOREIGN KEY (id_diretor) REFERENCES diretor(id),
    FOREIGN KEY (id_genero) REFERENCES genero(id)
);

CREATE TABLE lista (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    descricao VARCHAR(255)
);

CREATE TABLE filme_lista (
    id_filme INT NOT NULL,
    id_lista INT NOT NULL,
    PRIMARY KEY (id_filme, id_lista),
    FOREIGN KEY (id_filme) REFERENCES filme(id),
    FOREIGN KEY (id_lista) REFERENCES lista(id)
);
