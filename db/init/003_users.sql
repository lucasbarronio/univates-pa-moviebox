CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    login VARCHAR(50) NOT NULL UNIQUE,
    senha_hash CHAR(64) NOT NULL
);

INSERT INTO usuario (nome, login, senha_hash) VALUES
('Administrador', 'admin', encode(sha256('admin'::bytea), 'hex'));
