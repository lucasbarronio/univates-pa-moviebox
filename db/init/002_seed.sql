/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  lucas
 * Created: Sep 29, 2026
 */

INSERT INTO diretor (nome, nacionalidade) VALUES
('Christopher Nolan', 'Britânica'),
('Quentin Tarantino', 'Americana'),
('Steven Spielberg', 'Americana'),
('Sofia Coppola', 'Americana'),
('Bong Joon-ho', 'Sul-coreana'),
('Guillermo del Toro', 'Mexicana'),
('Denis Villeneuve', 'Canadense'),
('Greta Gerwig', 'Americana'),
('Jordan Peele', 'Americana'),
('Hayao Miyazaki', 'Japonesa');

INSERT INTO genero (nome) VALUES
('Ficção Científica'),
('Crime'),
('Aventura'),
('Drama'),
('Suspense'),
('Fantasia'),
('Terror'),
('Comédia'),
('Animação'),
('Romance');

INSERT INTO filme (
    titulo,
    ano_lancamento,
    sinopse,
    id_diretor,
    id_genero
) VALUES
(
    'A Origem',
    2010,
    'Um especialista em invadir sonhos recebe a missão de implantar uma ideia na mente de uma pessoa.',
    (SELECT id FROM diretor WHERE nome = 'Christopher Nolan'),
    (SELECT id FROM genero WHERE nome = 'Ficção Científica')
),
(
    'Pulp Fiction',
    1994,
    'Histórias de criminosos de Los Angeles se cruzam de maneiras inesperadas.',
    (SELECT id FROM diretor WHERE nome = 'Quentin Tarantino'),
    (SELECT id FROM genero WHERE nome = 'Crime')
),
(
    'Jurassic Park',
    1993,
    'Um parque com dinossauros clonados se transforma em uma situação perigosa.',
    (SELECT id FROM diretor WHERE nome = 'Steven Spielberg'),
    (SELECT id FROM genero WHERE nome = 'Aventura')
),
(
    'Encontros e Desencontros',
    2003,
    'Dois americanos desenvolvem uma amizade inesperada durante uma estadia em Tóquio.',
    (SELECT id FROM diretor WHERE nome = 'Sofia Coppola'),
    (SELECT id FROM genero WHERE nome = 'Drama')
),
(
    'Parasita',
    2019,
    'Uma família encontra uma maneira de se aproximar de uma família rica, gerando consequências inesperadas.',
    (SELECT id FROM diretor WHERE nome = 'Bong Joon-ho'),
    (SELECT id FROM genero WHERE nome = 'Suspense')
),
(
    'O Labirinto do Fauno',
    2006,
    'Uma jovem encontra um mundo fantástico durante um período de conflitos na Espanha.',
    (SELECT id FROM diretor WHERE nome = 'Guillermo del Toro'),
    (SELECT id FROM genero WHERE nome = 'Fantasia')
),
(
    'A Chegada',
    2016,
    'Uma linguista tenta estabelecer comunicação com seres extraterrestres que chegaram à Terra.',
    (SELECT id FROM diretor WHERE nome = 'Denis Villeneuve'),
    (SELECT id FROM genero WHERE nome = 'Ficção Científica')
),
(
    'Lady Bird',
    2017,
    'Uma adolescente enfrenta conflitos familiares e pessoais durante seu último ano escolar.',
    (SELECT id FROM diretor WHERE nome = 'Greta Gerwig'),
    (SELECT id FROM genero WHERE nome = 'Drama')
),
(
    'Corra!',
    2017,
    'Um jovem visita a família de sua namorada e percebe acontecimentos cada vez mais estranhos.',
    (SELECT id FROM diretor WHERE nome = 'Jordan Peele'),
    (SELECT id FROM genero WHERE nome = 'Terror')
),
(
    'A Viagem de Chihiro',
    2001,
    'Uma garota entra em um mundo fantástico habitado por espíritos e precisa encontrar uma forma de salvar seus pais.',
    (SELECT id FROM diretor WHERE nome = 'Hayao Miyazaki'),
    (SELECT id FROM genero WHERE nome = 'Animação')
);

INSERT INTO lista (nome, descricao) VALUES
('Favoritos', 'Filmes favoritos da coleção.'),
('Assistir novamente', 'Filmes que valem uma nova sessão.'),
('Ficção Científica', 'Filmes de ficção científica.'),
('Clássicos', 'Filmes considerados clássicos.'),
('Fim de semana', 'Filmes para assistir durante o fim de semana.'),
('Premiados', 'Filmes reconhecidos por grandes premiações.'),
('Suspense e Terror', 'Filmes para quem gosta de tensão e terror.'),
('Animações', 'Seleção de filmes de animação.'),
('Drama', 'Filmes com foco em histórias dramáticas.'),
('Anos 90', 'Filmes lançados durante a década de 1990.'),
('Anos 2000', 'Filmes lançados durante os anos 2000.'),
('Anos 2010', 'Filmes lançados durante os anos 2010.'),
('Diretores favoritos', 'Filmes de diretores favoritos.'),
('Para recomendar', 'Filmes que seriam boas recomendações.'),
('Minha seleção', 'Seleção pessoal de filmes variados.');

INSERT INTO filme_lista (id_filme, id_lista) VALUES
(
    (SELECT id FROM filme WHERE titulo = 'A Origem'),
    (SELECT id FROM lista WHERE nome = 'Favoritos')
),
(
    (SELECT id FROM filme WHERE titulo = 'A Origem'),
    (SELECT id FROM lista WHERE nome = 'Ficção Científica')
),
(
    (SELECT id FROM filme WHERE titulo = 'A Origem'),
    (SELECT id FROM lista WHERE nome = 'Anos 2010')
),
(
    (SELECT id FROM filme WHERE titulo = 'A Origem'),
    (SELECT id FROM lista WHERE nome = 'Assistir novamente')
);

INSERT INTO filme_lista (id_filme, id_lista) VALUES
(
    (SELECT id FROM filme WHERE titulo = 'Pulp Fiction'),
    (SELECT id FROM lista WHERE nome = 'Favoritos')
),
(
    (SELECT id FROM filme WHERE titulo = 'Pulp Fiction'),
    (SELECT id FROM lista WHERE nome = 'Clássicos')
),
(
    (SELECT id FROM filme WHERE titulo = 'Pulp Fiction'),
    (SELECT id FROM lista WHERE nome = 'Anos 90')
),
(
    (SELECT id FROM filme WHERE titulo = 'Pulp Fiction'),
    (SELECT id FROM lista WHERE nome = 'Diretores favoritos')
);

INSERT INTO filme_lista (id_filme, id_lista) VALUES
(
    (SELECT id FROM filme WHERE titulo = 'Jurassic Park'),
    (SELECT id FROM lista WHERE nome = 'Clássicos')
),
(
    (SELECT id FROM filme WHERE titulo = 'Jurassic Park'),
    (SELECT id FROM lista WHERE nome = 'Anos 90')
),
(
    (SELECT id FROM filme WHERE titulo = 'Jurassic Park'),
    (SELECT id FROM lista WHERE nome = 'Assistir novamente')
),
(
    (SELECT id FROM filme WHERE titulo = 'Jurassic Park'),
    (SELECT id FROM lista WHERE nome = 'Fim de semana')
);

INSERT INTO filme_lista (id_filme, id_lista) VALUES
(
    (SELECT id FROM filme WHERE titulo = 'Encontros e Desencontros'),
    (SELECT id FROM lista WHERE nome = 'Drama')
),
(
    (SELECT id FROM filme WHERE titulo = 'Encontros e Desencontros'),
    (SELECT id FROM lista WHERE nome = 'Anos 2000')
),
(
    (SELECT id FROM filme WHERE titulo = 'Encontros e Desencontros'),
    (SELECT id FROM lista WHERE nome = 'Minha seleção')
);

INSERT INTO filme_lista (id_filme, id_lista) VALUES
(
    (SELECT id FROM filme WHERE titulo = 'Parasita'),
    (SELECT id FROM lista WHERE nome = 'Favoritos')
),
(
    (SELECT id FROM filme WHERE titulo = 'Parasita'),
    (SELECT id FROM lista WHERE nome = 'Premiados')
),
(
    (SELECT id FROM filme WHERE titulo = 'Parasita'),
    (SELECT id FROM lista WHERE nome = 'Anos 2010')
),
(
    (SELECT id FROM filme WHERE titulo = 'Parasita'),
    (SELECT id FROM lista WHERE nome = 'Para recomendar')
);

INSERT INTO filme_lista (id_filme, id_lista) VALUES
(
    (SELECT id FROM filme WHERE titulo = 'O Labirinto do Fauno'),
    (SELECT id FROM lista WHERE nome = 'Anos 2000')
),
(
    (SELECT id FROM filme WHERE titulo = 'O Labirinto do Fauno'),
    (SELECT id FROM lista WHERE nome = 'Premiados')
),
(
    (SELECT id FROM filme WHERE titulo = 'O Labirinto do Fauno'),
    (SELECT id FROM lista WHERE nome = 'Minha seleção')
);

INSERT INTO filme_lista (id_filme, id_lista) VALUES
(
    (SELECT id FROM filme WHERE titulo = 'A Chegada'),
    (SELECT id FROM lista WHERE nome = 'Ficção Científica')
),
(
    (SELECT id FROM filme WHERE titulo = 'A Chegada'),
    (SELECT id FROM lista WHERE nome = 'Anos 2010')
),
(
    (SELECT id FROM filme WHERE titulo = 'A Chegada'),
    (SELECT id FROM lista WHERE nome = 'Para recomendar')
),
(
    (SELECT id FROM filme WHERE titulo = 'A Chegada'),
    (SELECT id FROM lista WHERE nome = 'Favoritos')
);

INSERT INTO filme_lista (id_filme, id_lista) VALUES
(
    (SELECT id FROM filme WHERE titulo = 'Lady Bird'),
    (SELECT id FROM lista WHERE nome = 'Drama')
),
(
    (SELECT id FROM filme WHERE titulo = 'Lady Bird'),
    (SELECT id FROM lista WHERE nome = 'Anos 2010')
),
(
    (SELECT id FROM filme WHERE titulo = 'Lady Bird'),
    (SELECT id FROM lista WHERE nome = 'Fim de semana')
);

INSERT INTO filme_lista (id_filme, id_lista) VALUES
(
    (SELECT id FROM filme WHERE titulo = 'Corra!'),
    (SELECT id FROM lista WHERE nome = 'Suspense e Terror')
),
(
    (SELECT id FROM filme WHERE titulo = 'Corra!'),
    (SELECT id FROM lista WHERE nome = 'Anos 2010')
),
(
    (SELECT id FROM filme WHERE titulo = 'Corra!'),
    (SELECT id FROM lista WHERE nome = 'Para recomendar')
);

INSERT INTO filme_lista (id_filme, id_lista) VALUES
(
    (SELECT id FROM filme WHERE titulo = 'A Viagem de Chihiro'),
    (SELECT id FROM lista WHERE nome = 'Favoritos')
),
(
    (SELECT id FROM filme WHERE titulo = 'A Viagem de Chihiro'),
    (SELECT id FROM lista WHERE nome = 'Animações')
),
(
    (SELECT id FROM filme WHERE titulo = 'A Viagem de Chihiro'),
    (SELECT id FROM lista WHERE nome = 'Anos 2000')
),
(
    (SELECT id FROM filme WHERE titulo = 'A Viagem de Chihiro'),
    (SELECT id FROM lista WHERE nome = 'Premiados')
);