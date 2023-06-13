
# API Java

Uma API em Java com Spring Boot.


## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente no seu application.properties

`spring.datasource.url=jdbc:mysql://localhost:3306/apijava`

`createDatabaseIfNotExist=true`

`spring.datasource.username=SEU USUARIO`

`spring.datasource.password=SUA SENHA`

`spring.jpa.hibernate.ddl-auto=update`

## Dependências / Recursos

| Nome               | Status                                                |
| ----------------- | ---------------------------------------------------------------- |
| Spring Web       | OK|
| Spring Data JPA       | OK |
| Validation     | OK |
| MySQL Driver      | OK |
| Lombok     | OK |
| Spring Security     |  |

## Documentação da API

#### Adiciona um usuário

```http
  POST /users
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `string` | **Obrigatório**. Nome do usuário |
| `password` | `string` | **Obrigatório**. Senha do usuário |

#### Atualiza um usuário

```http
  PUT /users/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `integer` | **Obrigatório**. ID do usuário |
| `name` | `string` | **Obrigatório**. Nome do usuário |
| `password` | `string` | **Obrigatório**. Senha do usuário |

#### Obtem todos os usuários

```http
  GET /users
```

#### Obtem um usuário

```http
  GET /users/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `integer` | **Obrigatório**. ID do usuário |

#### Deleta um usuário

```http
  DELETE /users/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `integer` | **Obrigatório**. ID do usuário |
