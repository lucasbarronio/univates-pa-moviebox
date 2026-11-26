# Moviebox

Moviebox é uma aplicação desktop em Java para cadastrar filmes, diretores, gêneros e listas. O projeto foi desenvolvido para a disciplina de Programação Avançada da UNIVATES.

## Requisitos

- Git
- JDK 21
- Maven
- Docker
- Docker Compose

A porta `5432` precisa estar disponível.

## Executar

Clone o projeto:

```bash
git clone https://github.com/lucasbarronio/univates-pa-moviebox.git
cd univates-pa-moviebox
```

Crie o arquivo `.env` a partir do exemplo e revise os valores no `.env`.:

```bash
cp .env.example .env
```

Inicie o banco. Na primeira execução, o Docker cria o esquema e carrega os dados iniciais.

```bash
docker compose up -d
```

Compile, execute os testes e gere o JAR. O JAR executável fica em `target/moviebox-1.0.jar`:

```bash
mvn -B verify
```

Execute o JAR:

```bash
java -jar ./target/moviebox-1.0.jar
```

## Encerrar

Pare o banco:

```bash
docker compose down
```

Para apagar também os dados armazenados:

```bash
docker compose down -v
```
