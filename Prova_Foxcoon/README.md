markdown

Aluno API - Processo Seletivo



Uma API REST desenvolvida com **Spring Boot** e banco de dados **H2** em memória, criada para o gerenciamento de alunos, suas respectivas matérias e notas acadêmicas, atendendo aos requisitos do exercício prático.



\---



Tecnologias Utilizadas



\* **Java 17** (ou superior)

\* **Spring Boot 3.x**

&#x20;   \* Spring Data JPA (Persistência e mapeamento objeto-relacional)

&#x20;   \* Spring Web (Construção dos endpoints REST)

\* **Banco de Dados H2** (Em memória para execução rápida sem necessidade de instalação local)

\* **Lombok** (Produtividade e eliminação de código boilerplate)

\* **Maven** (Gerenciador de dependências e build)



\---



Como Executar o Projeto



\### Pré-requisitos

\* Java 17 ou superior instalado.

\* Maven instalado (opcional, caso use o wrapper `./mvnw` incluso).



\### Passos para execução

1\. Clone o repositório em sua máquina:

&#x20;  ```bash

&#x20;  git clone \[https://github.com/Pedro-Mrqs/ExercicioFoxconn.git](https://github.com/Pedro-Mrqs/ExercicioFoxconn.git)



```



2\. Acesse a pasta raiz do projeto:

```bash

cd NOME\_DO\_REPOSITORIO



```





3\. Execute a aplicação com o Maven:

```bash

./mvnw spring-boot:run



```





\*(No Windows, utilize o comando: `mvnw.cmd spring-boot:run`)\*



A API iniciará com o Tomcat rodando na porta padrão \*\*8080\*\* (`http://localhost:8080`).



\---



\## Banco de Dados e Carga Inicial



A API está configurada para utilizar o banco de dados relacional **H2 em memória**. Para facilitar a avaliação, o projeto conta com uma classe de inicialização (`DataInitializer`) que realiza a carga automática de todos os dados de estudantes, matérias e notas descritos na tabela do enunciado logo no primeiro boot.



Para inspecionar as tabelas e o banco de dados graficamente:



\* **URL de Acesso:** `http://localhost:8080/h2-console`

\* **JDBC URL**: `jdbc:h2:mem:alunodb`

\* **Username**: `sa`

\* **Password**: \*(deixar em branco)\*



\---



\## Endpoints da API



\### 1. Retornar todos os alunos e suas matérias (Tarefa 4)



\* **Método**: `GET`

\* **URL**: `/api/alunos`

\* **Resposta esperada (200 OK):**

```json

\[

&#x20; {

&#x20;   "matricula": 1,

&#x20;   "nome": "Erik Oliver",

&#x20;   "sexo": "M",

&#x20;   "nascimento": "1987-10-10",

&#x20;   "materias": \[

&#x20;     { "materia": "Matemática", "notaFinal": 10.0 },

&#x20;     { "materia": "Fisica", "notaFinal": 9.0 }

&#x20;   ]

&#x20; }

]



```







\### 2. Retornar alunos com notas superiores a 8 (Tarefa 5)



\* **Método**: `GET`

\* **URL**: `/api/alunos/notas-altas`

\* **Descrição**: Filtra e retorna exclusivamente os alunos que possuem notas maiores que 8.



\### 3. Inserir novos alunos e suas matérias (Tarefa 2)



\* **Método**: `POST`

\* **URL**: `/api/alunos`

\* **Corpo da Requisição (JSON)**:

```json

{

&#x20; "nome": "Mariana Lima",

&#x20; "sexo": "F",

&#x20; "nascimento": "1999-03-22",

&#x20; "materias": \[

&#x20;   { "materia": "História", "notaFinal": 8.5 },

&#x20;   { "materia": "Química", "notaFinal": 7.0 }

&#x20; ]

}



```







\### 4. Atualizar dados do aluno e matérias (Tarefa 3)



\* **Método**: `PUT`

\* **URL**: `/api/alunos/{matricula}`

\* **Descrição**:\*\* Atualiza os dados cadastrais (nome, sexo, nascimento) e substitui/gerencia a lista de matérias permitindo inserções e exclusões.

\* **Corpo da Requisição (JSON):**

```json

{

&#x20; "nome": "Erik Oliver Alterado",

&#x20; "sexo": "M",

&#x20; "nascimento": "1987-10-10",

&#x20; "materias": \[

&#x20;   { "materia": "Matemática", "notaFinal": 9.5 }

&#x20; ]

}



```







\---



\##Diferenciais Implementados (Extras)



\* **Arquitetura Limpa em Camadas:** Divisão bem estruturada entre `Controller`, `Service`, `Repository`, `Model` e `DTO`.

\* **Uso de DTOs (Data Transfer Objects):** Evita expor diretamente as entidades do banco de dados na camada de apresentação, garantindo melhor segurança e encapsulamento.

\* **Tratamento Global de Exceções:** Implementação de um `GlobalExceptionHandler` acoplado ao Spring para interceptar erros (como buscar ou atualizar uma matrícula inexistente) e responder com mensagens limpas em formato JSON acompanhadas do status HTTP correto (`404 Not Found`).



\---



Desenvolvido por \[Pedro Marques](https://github.com/Pedro-Mrqs/ExercicioFoxconn).









