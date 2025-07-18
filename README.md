# API REST de Disciplinas - UFRA

API para gerenciamento de disciplinas acadêmicas usando Spring Boot, PostgreSQL e Docker.

## Como executar este projeto

1. **Clone este repositório:**

```sh
git clone https://github.com/inaciodinucci/NapDevWeb1.git
cd NapDevWeb1
```

2. **Suba o banco de dados PostgreSQL com Docker:**

```sh
docker run --name nap01dev -e POSTGRES_DB=disciplina_db -e POSTGRES_USER=aula -e POSTGRES_PASSWORD=senha -p 5428:5432 -d postgres
```

3. **Compile e execute a aplicação:**

```sh
mvn clean install -DskipTests
mvn spring-boot:run
```

4. **Acesse a API:**

A aplicação estará disponível em: [http://localhost:8080/disciplinas](http://localhost:8080/disciplinas)

## Pré-requisitos
- Java 17+
- Maven
- Docker

## Endpoints

- `GET /disciplinas` - Lista todas as disciplinas
- `GET /disciplinas/{id}` - Busca disciplina por ID
- `POST /disciplinas` - Cria nova disciplina
- `PUT /disciplinas/{id}` - Atualiza disciplina
- `DELETE /disciplinas/{id}` - Remove disciplina

## Exemplos de Requisições

### Criar disciplina
```bash
curl -X POST http://localhost:8080/disciplinas \
  -H "Content-Type: application/json" \
  -d '{"nome":"Matemática","professor":"João Silva","indice":7.5,"codigo":101}'
```

### Listar todas
```bash
curl http://localhost:8080/disciplinas
```

### Buscar por ID
```bash
curl http://localhost:8080/disciplinas/1
```

### Atualizar
```bash
curl -X PUT http://localhost:8080/disciplinas/1 \
  -H "Content-Type: application/json" \
  -d '{"nome":"Matemática II","professor":"João Silva","indice":8.0,"codigo":101}'
```

### Deletar
```bash
curl -X DELETE http://localhost:8080/disciplinas/1
```

## Scripts SQL de Teste

```sql
INSERT INTO disciplina (nome, professor, indice, codigo) VALUES ('Matemática', 'João Silva', 7.5, 101);
INSERT INTO disciplina (nome, professor, indice, codigo) VALUES ('Física', 'Maria Souza', 6.8, 102);
INSERT INTO disciplina (nome, professor, indice, codigo) VALUES ('Química', 'Carlos Lima', 8.2, 103);
```

## Boas Práticas e Melhorias
- Use DTOs para separar entidade do modelo de API
- Adicione validação com Bean Validation
- Implemente paginação em `GET /disciplinas`
- Adicione Swagger/OpenAPI para documentação automática

## Tratamento de Erros
- Respostas padronizadas em JSON
- Status HTTP apropriados (201, 204, 404) 