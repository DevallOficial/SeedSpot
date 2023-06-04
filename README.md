# SeedSpot
 Um aplicativo de registro de hortas sustentáveis e caseiras, com intuito de incentivar a produção de alimentos orgânicos e informar sobre possíveis técnicas de plantio a serem utilizadas.
 O SeedSpot promove a produção de alimentos saudáveis e livres de agrotóxicos, permitindo que as pessoas tenham maior controle sobre o que consomem e incentivando a adoção de uma alimentação mais equilibrada, e fornece informações e técnicas de plantio de forma acessível aos usuários, já que muitas pessoas têm interesse em cultivar suas próprias hortas, mas podem não ter acesso a informações adequadas ou conhecimento técnico sobre o assunto.
 Nesta documentação, você encontrará informações detalhadas sobre as rotas disponíveis, os parâmetros necessários e as respostas retornadas pela API.
 
 ## Contribuidores 
 
 - [Caio Henrique Martins](https://github.com/Caiohrqm)
 - [Gabriela Vieira](https://github.com/vieiragab)
 - [Isadora Antunes](https://github.com/NhakiB)
 - [Maria Eduarda Herrera](https://github.com/herrera3)

## Endpoints
- Usuário
    - [Cadastrar](#cadastrar-usuario)
    - [Listar](#listar-usuarios)
    - [Detalhar](#detalhar-usuarios)
    - [Alterar](#alterar-usuarios)
    - [Excluir](#excluir-usuarios)

- Telefone
    - [Cadastrar](#cadastrar-telefone)
    - [Detalhar](#detalhar-telefone)
    - [Alterar](#alterar-telefone)
    - [Excluir](#excluir-telefone)

- Publicação
    - [Cadastrar](#cadastrar-publicacao)
    - [Detalhar](#detalhar-publicacao)
    - [Alterar](#alterar-publicacao)
    - [Excluir](#excluir-publicacao)

- Comentário
    - [Cadastrar](#cadastrar-comentario)
    - [Detalhar](#detalhar-comentario)
    - [Alterar](#alterar-comentario)
    - [Excluir](#excluir-comentario)
    
- Curtida
    - [Cadastrar](#cadastrar-curtida)
    - [Detalhar](#detalhar-curtida)
    - [Excluir](#excluir-curtida)

- Mensagem
    - [Cadastrar](#cadastrar-mensagem)
    - [Detalhar](#detalhar-mensagem)
    - [Excluir](#excluir-mensagem)

u
### Cadastrar usuário

`POST` /api/usuarios

| campo | tipo | obrigatório | descrição
|-------|------|-------------|-----------
| nome | string | sim | nome do usuário |
| email | string | sim | email de acesso e comunicação do usuário |
| senha | string | sim | senha de acesso do usuário |
| estado | string | sim | estado de origem do usuário |
| cidade | string | sim | cidade de origem do usuário |

**Exemplo de corpo de requisição**

```json
{
    "nome": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll123",
    "estado": "São Paulo",
    "cidade": "Cotia"
}
```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "nome": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll123",
    "estado": "São Paulo",
    "cidade": "Cotia"
}

```

**Códigos de resposta**




| codigo | descrição |
|--------|-----------|
| 201 | Indica que a requisição POST foi bem-sucedida e o servidor criou um novo recurso como resultado |
| 404 | Indica que o recurso solicitado na requisição POST não foi encontrado no servidor |
| 500 | Indica que ocorreu um erro interno no servidor ao processar a requisição POST |

---

    
### Listar usuários
`GET` /api/usuarios

**Exemplo de Corpo de resposta**

```json
[
    {
    "id": 1,
    "nome": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll123",
    "estado": "São Paulo",
    "cidade": "Cotia"
    },
    {
    "id": 2,
    "nome": "SeedSpot",
    "email": "empresarial@SeedSpot.com.br",
    "senha": "SeedSpot",
    "estado": "Pernambuco",
    "cidade": "Recife"
    }
]

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|

---


### Detalhar usuário
`GET` /api/usuario/{id}
  
    
**Parâmetros de caminho**

id - código do usuário a ser detalhado

**Exemplo de Corpo de resposta** 

```json
{
    "id": 1,
    "nome": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll123",
    "estado": "São Paulo",
    "cidade": "Cotia"
}

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|


---

### Alterar usuário

`PUT` /api/usuario/{id}

        
**Parâmetros de caminho**

id - código do usuário a ser alterado
    
**Exemplo de corpo de requisição**

```json
{
    "nome": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll321",
    "estado": "Pernambuco",
    "cidade": "Recife"
}

```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "nome": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll321",
    "estado": "Pernambuco",
    "cidade": "Petrolina"
}
```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição PUT foi bem-sucedida e o recurso foi atualizado com sucesso|
| 404 | O recurso que a requisição PUT está tentando atualizar não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição PUT|

---

### Excluir usuário

`DELETE` /api/usuario/{id}

**Parâmetros de caminho**

id - código do usuário a ser excluído

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | este código é usado para indicar que a requisição DELETE foi bem-sucedida e o recurso foi excluído com sucesso. |
| 404  | este código é usado quando o recurso que a requisição DELETE está tentando excluir não pode ser encontrado| 
| 500  | este código é usado quando ocorre um erro interno do servidor ao processar a requisição DELETE|

---

### Cadastrar telefone

`POST` /api/telefones

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
| numeroDDD | int | sim | número do DDD do telefone do usuário|
| numeroDDI | int | sim | número do DDD do telefone do usuário |
| nrTelefone | int | sim | número do telefone do usuário |

**Exemplo de corpo de requisição**

```json

{
    "numeroDDD": 55,
    "numeroDDI": 1,
    "nrTelefone": 987654321
}

```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "numeroDDD": 55,
    "numeroDDI": 1,
    "nrTelefone": 987654321
}

```

**Códigos de resposta**


| codigo | descrição |
|--------|-----------|
| 201 | Indica que a requisição POST foi bem-sucedida e o servidor criou um novo recurso como resultado |
| 404 | Indica que o recurso solicitado na requisição POST não foi encontrado no servidor |
| 500 | Indica que ocorreu um erro interno no servidor ao processar a requisição POST |

---

### Detalhar telefone
`GET` /api/telefones/{id}
  
    
**Parâmetros de caminho**

id - código do telefone a ser detalhado

**Exemplo de Corpo de resposta** 

```json
{
        "id": 1,
        "numeroDDD": 11,
        "numeroDDI": 55,
        "nrTelefone": 987654321
    }

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|

---

### Alterar telefone

`PUT` /api/telefones/{id}

        
**Parâmetros de caminho**

id - código do telefone a ser alterado
    
**Exemplo de corpo de requisição**

```json
{
    {
    "numeroDDD": 55,
    "numeroDDI": 212,
    "nrTelefone": 987654321
}
}

```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "numeroDDD": 55,
    "numeroDDI": 212,
    "nrTelefone": 987654321
}
```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição PUT foi bem-sucedida e o recurso foi atualizado com sucesso|
| 404 | O recurso que a requisição PUT está tentando atualizar não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição PUT|

---

### Excluir telefone

`DELETE` /api/telefones/{id}

**Parâmetros de caminho**

id - código do telefone a ser excluido

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | este código é usado para indicar que a requisição DELETE foi bem-sucedida e o recurso foi excluído com sucesso. |
| 404  | este código é usado quando o recurso que a requisição DELETE está tentando excluir não pode ser encontrado| 
| 500  | este código é usado quando ocorre um erro interno do servidor ao processar a requisição DELETE|

---

### Cadastrar Publicação

`POST` /api/publicacoes

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
| conteúdo | string | sim | Conteúdo da publicação |
| usuarioId | string | sim | 	ID do autor da publicação |
| anexo | byte | não | anexo da publicação |
| data | date | sim | Data da publicação (formato: yyyy-MM-dd) |
| hora | dateTime | sim | hora da publicação |

**Exemplo de corpo de requisição**

```json

{
    "título": "Dicas para cultivo de tomates",
    "conteúdo": "Aqui estão algumas dicas para o cultivo saudável de tomates...",
    "usuarioId": 1,
    "anexo": "<conteúdo do anexo em formato byte>",
    "data": "2023-05-28",
    "hora": "14:30:00"

}

```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "título": "Dicas para cultivo de tomates",
    "conteúdo": "Aqui estão algumas dicas para o cultivo saudável de tomates...",
    "usuarioId": 1,
    "anexo": "<conteúdo do anexo em formato byte>",
    "data": "2023-05-28",
    "hora": "14:30:00"
}

```

**Códigos de resposta**


| codigo | descrição |
|--------|-----------|
| 201 | Indica que a requisição POST foi bem-sucedida e o servidor criou um novo recurso como resultado |
| 404 | Indica que o recurso solicitado na requisição POST não foi encontrado no servidor |
| 500 | Indica que ocorreu um erro interno no servidor ao processar a requisição POST |

---

### Detalhar Publicação
`GET` /api/publicacoes/{id}
  
    
**Parâmetros de caminho**

id - ID da publicação a ser detalhada

**Exemplo de Corpo de resposta** 

```json
{
    "id": 1,
    "título": "Dicas para cultivo de tomates",
    "conteúdo": "Aqui estão algumas dicas para o cultivo saudável de tomates...",
    "usuarioId": 1,
    "anexo": "<conteúdo do anexo em formato byte>",
    "data": "2023-05-28",
    "hora": "14:30:00"
}


```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|

---

### Alterar Publicação

`PUT` /api/publicacoes/{id}

        
**Parâmetros de caminho**

id - ID da publicação a ser atualizada
    
**Exemplo de corpo de requisição**

```json
{
    "título": "Dicas para cultivo de tomates",
    "conteúdo": "Aqui estão algumas dicas para o cultivo saudável de tomates...",
    "usuarioId": 1,
    "anexo": "<conteúdo do anexo em formato byte>",
    "data": "2023-05-28",
    "hora": "14:30:00"
}


```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "título": "Dicas para cultivo de tomates",
    "conteúdo": "Aqui estão algumas dicas para o cultivo saudável de tomates...",
    "usuarioId": 1,
    "anexo": "<conteúdo do anexo em formato byte>",
    "data": "2023-05-28",
    "hora": "14:30:00"
}

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição PUT foi bem-sucedida e o recurso foi atualizado com sucesso|
| 404 | O recurso que a requisição PUT está tentando atualizar não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição PUT|

---

### Excluir Publicação

`DELETE` /api/publicacoes/{id}

**Parâmetros de caminho**

id - ID da publicação a ser excluída

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | este código é usado para indicar que a requisição DELETE foi bem-sucedida e o recurso foi excluído com sucesso. |
| 404  | este código é usado quando o recurso que a requisição DELETE está tentando excluir não pode ser encontrado| 
| 500  | este código é usado quando ocorre um erro interno do servidor ao processar a requisição DELETE|

---

### Cadastrar Comentário

`POST` /api/comentarios

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
| conteúdo | string | sim | Conteúdo do comentário |
| usuarioId | int | sim |ID do autor do comentário |
| publicacaoId | int | sim | ID da publicação em que o comentário será adicionado |
| data | date | sim | Data da publicação (formato: yyyy-MM-dd) |
| hora | dateTime | sim | hora da publicação |

**Exemplo de corpo de requisição**

```json

{
    "publicacaoId": 1,
    "usuarioId": 1,
    "conteudo": "Ótima dica! Vou aplicar no meu cultivo de tomates.",
    "data": "2023-05-28",
    "hora": "14:32:00"
}



```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "publicacaoId": 1,
    "usuarioId": 1,
    "conteudo": "Ótima dica! Vou aplicar no meu cultivo de tomates.",
    "data": "2023-05-28",
    "hora": "14:32:00"
}


```

**Códigos de resposta**


| codigo | descrição |
|--------|-----------|
| 201 | Indica que a requisição POST foi bem-sucedida e o servidor criou um novo recurso como resultado |
| 404 | Indica que o recurso solicitado na requisição POST não foi encontrado no servidor |
| 500 | Indica que ocorreu um erro interno no servidor ao processar a requisição POST |

---

### Detalhar Comentário
`GET` /api/comentarios/{id}
  
    
**Parâmetros de caminho**

id - ID do comentário a ser detalhado

**Exemplo de Corpo de resposta** 

```json
{
    "id": 1,
    "publicacaoId": 1,
    "usuarioId": 1,
    "conteudo": "Ótima dica! Vou aplicar no meu cultivo de tomates.",
    "data": "2023-05-28",
    "hora": "14:32:00"
}



```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|

---

### Alterar Comentário

`PUT` /api/comentarios/{id}

        
**Parâmetros de caminho**

id - ID do comentário a ser atualizado
    
**Exemplo de corpo de requisição**

```json
{
    "publicacaoId": 1,
    "usuarioId": 1,
    "conteudo": "Ótima dica! Vou aplicar no meu cultivo de tomates. Obrigado!",
    "data": "2023-05-28",
    "hora": "14:32:00"
}



```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "publicacaoId": 1,
    "usuarioId": 1,
    "conteudo": "Ótima dica! Vou aplicar no meu cultivo de tomates. Obrigado!",
    "data": "2023-05-28",
    "hora": "14:32:00"
}


```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição PUT foi bem-sucedida e o recurso foi atualizado com sucesso|
| 404 | O recurso que a requisição PUT está tentando atualizar não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição PUT|

---

### Excluir Comentário

`DELETE` /api/comentarios/{id}

**Parâmetros de caminho**

id - ID do comentário a ser excluído

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | este código é usado para indicar que a requisição DELETE foi bem-sucedida e o recurso foi excluído com sucesso. |
| 404  | este código é usado quando o recurso que a requisição DELETE está tentando excluir não pode ser encontrado| 
| 500  | este código é usado quando ocorre um erro interno do servidor ao processar a requisição DELETE|

---

### Cadastrar Curtida

`POST` /api/curtidas

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
| usuarioId | int | sim |ID do usuário que realizou a curtida |
| publicacaoId | int | sim | ID da publicação que recebeu a curtida |
| data | date | sim | Data da curtida (formato: yyyy-MM-dd) |
| hora | dateTime | sim | hora da curtida |

**Exemplo de corpo de requisição**

```json

{
    "usuarioId": 1,
    "publicacaoId": 1,
    "data": "2023-05-28",
    "hora": "14:32:00"
}



```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "usuarioId": 1,
    "publicacaoId": 1,
    "data": "2023-05-28",
    "hora": "14:32:00"
}




```

**Códigos de resposta**


| codigo | descrição |
|--------|-----------|
| 201 | Indica que a requisição POST foi bem-sucedida e o servidor criou um novo recurso como resultado |
| 404 | Indica que o recurso solicitado na requisição POST não foi encontrado no servidor |
| 500 | Indica que ocorreu um erro interno no servidor ao processar a requisição POST |

---

### Detalhar Curtida
`GET` /api/curtidas/{id}
  
    
**Parâmetros de caminho**

id - código da curtida a ser detalhada

**Exemplo de Corpo de resposta** 

```json
{
    "id": 1,
    "usuarioId": 1,
    "publicacaoId": 1,
    "data": "2023-05-28",
    "hora": "09:30:00"
}




```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|

---


### Excluir Curtida

`DELETE` /api/curtidas/{id}

**Parâmetros de caminho**

id - código da curtida a ser excluída

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | este código é usado para indicar que a requisição DELETE foi bem-sucedida e o recurso foi excluído com sucesso. |
| 404  | este código é usado quando o recurso que a requisição DELETE está tentando excluir não pode ser encontrado| 
| 500  | este código é usado quando ocorre um erro interno do servidor ao processar a requisição DELETE|

---
### Cadastrar Mensagem

`POST` /api/mensagens

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
| conteúdo | string | sim | Conteúdo da mensagem |
| data | date | sim | Data da mensagem (formato: yyyy-MM-dd) |
| hora | dateTime | sim | hora da mensagem |

**Exemplo de corpo de requisição**

```json

{
    "conteudo": "Olá, como posso te ajudar?",
    "data": "2023-05-28",
    "hora": "09:30:00"
}




```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "conteudo": "Olá, como posso te ajudar?",
    "data": "2023-05-28",
    "hora": "09:30:00"
}



```

**Códigos de resposta**


| codigo | descrição |
|--------|-----------|
| 201 | Indica que a requisição POST foi bem-sucedida e o servidor criou um novo recurso como resultado |
| 404 | Indica que o recurso solicitado na requisição POST não foi encontrado no servidor |
| 500 | Indica que ocorreu um erro interno no servidor ao processar a requisição POST |

---

### Detalhar Mensagem
`GET` /api/mensagens/{id}
  
    
**Parâmetros de caminho**

id - código da mensagem a ser detalhada

**Exemplo de Corpo de resposta** 

```json
{
    "id": 1,
    "conteudo": "Olá, como posso te ajudar?",
    "data": "2023-05-28",
    "hora": "09:30:00"
}




```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|

---



### Excluir Mensagem

`DELETE` /api/mensagens/{id}

**Parâmetros de caminho**

id - código da mensagem a ser excluída

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | este código é usado para indicar que a requisição DELETE foi bem-sucedida e o recurso foi excluído com sucesso. |
| 404  | este código é usado quando o recurso que a requisição DELETE está tentando excluir não pode ser encontrado| 
| 500  | este código é usado quando ocorre um erro interno do servidor ao processar a requisição DELETE|

---
