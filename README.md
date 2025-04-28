# library-book-api

## 1. Definição de arquitetura


API Rest para consultas de livros para uma biblioteca. A aplicação permite buscar todos os livros disponiveis, buscar livro por id, livros por genero e nome do autor.

Utiliza as seguintes tecnologias para funcionamento:
    
    - Spring Data JPA
    - Spring Data Redis - Cache
    - Spring Boot Cache - Melhorar tempo de resposta dos endpoints de busca
    - Spring Data elasticsearch - Banco de dados NoSQL
    - Spring Boot Web
    - Spring Cloud Openfeign - Carga inicial de livros
    
A estrutura/pattern de library-book-api esta separa por camadas de dominio. No dominio de books estao concentradas todas a funcionalidades e estruturas nescessárias para a funcionamento das buscas de livros. Essas são as classes de repository, dtos e services.

O domínio de data sync possui toda a estrutura relacionada a carga inicial de dados de Book no elasticsearch, sendo elas o cliente onde é feita a busca dos livros, repository, service, dtos e executável.

Existe tambem, uma separação do que é estrutural/infraestrutura, como as models Book e Author. Dessa forma, é possível reutilizar a classe que representa o objeto no banco de dados nos dominios.


## 2. Detalhes da Implementação:

Na aplicação temos 4 principais endpoints disponíveis. É possível visualizar os detalhes de Resposta e pametros de buscas desses endpoints atrvés do swagger:
http://localhost:8080/library-book/api/swagger-ui/index.html#/

   - GET All Books
     - Busca todos os livros salvos no banco de dados
     ```curl
        curl --location 'http://localhost:8080/library-book/api/books'
        ```

   - GET Book by ID
     - Tras o livro pertencente ao id informado
     ``` curl
       curl --location 'http://localhost:8080/library-book/api/books/54ac21d1-b5b5-4a09-a16f-1068cdf43b04'
     ```

   - GET Books by Genre
     - Busca todos os livros de um determinado genero
     ```curl
       curl --location 'http://localhost:8080/library-book/api/books/genre/HORROR'
     ```
     
   - GET Books by Author Name
     - Busca todos os livros que possuem o nome do autor informado
     ```curl
       curl --location 'http://localhost:8080/library-book/api/books/genre/HORROR'
     ```

Como o foco desta api para é a busca de livros, os dados estao sendo armazenados em banco de dados NoSQL elasticsearch.
Com isso, tem menos "complexidade/custos" de relacionar Books e Author. 

O Elasticsearch foi escolhido por se tratar de um banco dados que armazena documentos e sua facilicidade em fazer buscas comparados a outros bancos de dados NoSQL documental.

É facilmente escalável e possui alta disponibilidade.

A classe que representa o a estrutura de dados é BookDocument. Dentro de BookDocument, existe a lista de AuthorDocument.

Os Ids das estuturas de Book e Author sao UUID's gerenciados pela app.

As services do domínio de Book são reponsáveis por consultar os livros através da repository de BookRepository. Que é uma interface e extende ElasticsearchRepository, facilitando as buscas, já que métodos mais genéricos existem por padrão (findAll,FindById, deleteAll e etc)
Na BookRepository foi nescessário criar mais dois metódos de buscas, o findByGenre e FindByAuhtorsName.

No domínio de data sync, também temos as camadas de services e repository. Neste dominio, estão as implementações nescessárias para a carga de dados de BookDocument inicial, porém existem mais algumas camadas segregadas, a do cliente de openlibrary onde é realizada a busca dos livros e em seguida transformados na dto de books para posteriormente serem gravada na base de dados.

Mesmo as consultas sendo relativamente rapidas, os retornos do dominio books service que alimentam os endpoints estão sendo armazenados em cache Redis

O tempo de expiração do cache está em milisegundos e pode ser alterado através da config **cache.ttl.ms**

Atualmente, o cache esta configurado para 12 horas. A cada 12 horas o cache é renovado automaticamente.


## 3.Melhorias

- Mesmo segregando as camadas, ainda existe um certo acoplamento entre a camada de service/repository, já que esta sendo utilizada a propria interface, retornando para a service Optional e Inteble do próprio document. Neste caso, para ser possível ter um pattern de DDD, poderia ter uma implementação da interface de Repository que retorna para a service o obejto dto  já parsiado, Neste caso, poderíasmos trocar o fornecimento dos dados por qualquer outra fonte sem ter muito impacto na camada de service. Reduzindo riscos de alteraçõs de regras de negócio por acidente.

- No endpoint de busca de livros por authorName, a busca esta com a padrao elasticsearch, onde a busca é feita pela palavra toda e não só por um trrecho dela (ex.: Se buscar por "jo" ele não tras resultado, mas "John" sim) 

- Adicionar a paginação, uma vez que não nenhum limitador de itens nas respostas dos endpoints


Maiores dore durante o desenvolvimento:
