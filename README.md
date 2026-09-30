# Moviebox

Moviebox é uma aplicação desktop em Java para cadastrar filmes, diretores, gêneros e listas. O projeto foi desenvolvido para a disciplina de Programação Avançada da UNIVATES.

## Requisitos

- Git
- JDK 21
- Maven
- Docker
- Docker Compose

A porta `5432` deve estar disponível.

## Executar

Clone o projeto:

```bash
git clone https://github.com/lucasbarronio/univates-pa-moviebox.git
cd univates-pa-moviebox
```

Crie o arquivo `.env`:

```bash
cp .env.example .env
```

Configure:

```dotenv
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
POSTGRES_DB=univates-pa
```

Crie o arquivo `db.properties` na raiz do projeto:

```properties
db.driver=org.postgresql.Driver
db.url=jdbc:postgresql://localhost:5432/univates-pa
db.user=postgres
db.senha=postgres
```

Inicie o banco de dados:

```bash
docker compose up -d
```

Na primeira execução, o banco e os dados iniciais são criados automaticamente.

Execute a aplicação:

```bash
mvn compile exec:java
```

## Encerrar

Pare o banco de dados:

```bash
docker compose down
```

Para apagar também os dados armazenados:

```bash
docker compose down -v
```
