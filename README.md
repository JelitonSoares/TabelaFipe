# 🚙Tabela FIPE🚗:

Projeto desenvolvido como desafio do curso de SpringBoot da Alura, consiste em consumir uma API pública da tabela FIPE,
e simular uma consulta à tabela, utilizando os endpoints para realizar as requisições, obtendo listas com as marcas, 
modelos e por fim os anos com valores dos veículos.
## 📚Documentação

* [API TABELA FIPE](https://deividfortuna.github.io/fipe/)
* [SpringBoot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
* [Java](https://docs.oracle.com/en/java/javase/17/docs/api/index.html)
* [Jackson](https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-databind/latest/index.html)

## 🎓Aprendizados:

Adquiri muitas habilidades na construção deste projeto, aprendi a trabalhar melhor com Streams, utilizando operações mais avançadas como:
* flatMap()
* filter()
* collect()
* findFirst()
  
Entre outas, também revisei funções Lambda(funções anônimas), como realiar requisições HTTP em Java, Generics e Optional. \
Enfretei também algumas dificuldades, entre elas, o retorno da API que consistia em um array de JSONs, retorno este que nunca havia trabalhado, aliás de não ter implmentado uma funcionalidade tão eficiente na minha opinião, posteriormente aprendi uma classe que poderia ter me ajudado bastante.
* CollectionType - [Doc](https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-databind/latest/index.html)
  
No mais foi muito prazeroso ter desenvolvido esta aplicação para expandir meus conhecimentos.

## 📱Screenshots

* Primeiro o programa exibe três opções para o usuário escolher:\
  ![Parte-1](https://github.com/JelitonSoares/TabelaFipe/assets/132035058/94d5b87a-7d9c-4d9b-bd1e-da880cecbef5)
* Logo depois ele exibe uma lista de marcas do tipo de veículo escolhido (Neste caso carros):\
  ![parte-2](https://github.com/JelitonSoares/TabelaFipe/assets/132035058/c51fffd9-5317-4dce-bac5-dce917cc2d15)
* O usuário deve digitar o código da marca:\
  ![parte-3](https://github.com/JelitonSoares/TabelaFipe/assets/132035058/2e7a5593-b363-4221-8b9e-0729f2d07871)
* O programa listará os modelos da marca escolhida(Neste caso: modelos da Fiat):\
  ![parte-4](https://github.com/JelitonSoares/TabelaFipe/assets/132035058/91b57eb7-9a2a-44e0-8eef-e424ad834018)
* E então depois de selecionado o modelo o programa deve exibir todos os anos desse modelo disponíveis e seus
  respectivos valores:\
  ![parte-5](https://github.com/JelitonSoares/TabelaFipe/assets/132035058/531ed516-b978-4240-b978-0e0b375377fd)

Após isso o programa deverá encerrar e caso o usuário queira realizar uma nova consulta deve inicia-lo novamente.


  



