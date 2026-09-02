
Versão em Java de um sistema de promoções, desenvolvida como projeto pessoal 
para aplicar na prática os conceitos aprendidos em Java. É uma reimplementação 
simplificada de uma ideia também explorada em PHP (PromoSearch), esta versão 
não inclui a funcionalidade de mapa/geolocalização presente na versão original.

## Funcionalidades

- Cadastro e login de usuários, com perfis de Administrador e Cliente
- Vendedores publicam promoções, que ficam visíveis para os clientes
- Sistema de denúncia de promoções/vendedores
- Persistência de dados local

## Tecnologias

- Java + JavaFX (interface gráfica desktop)
- Maven (build e gerenciamento de dependências)
- Sistema de módulos do Java (JPMS)

## Como executar

```
bash

./mvnw javafx:run
```

## Sobre o projeto

Projeto pequeno, feito para consolidar conceitos de Java, estrutura de 
classes, persistência de dados e interface gráfica com JavaFX, através 
de um caso de uso completo, do cadastro de usuário à publicação e 
visualização de promoções. Existe também uma versão em PHP deste mesmo 
conceito ([PromoSearch](https://github.com/BabbingtonnJR/PromoSearch)), 
com a diferença de incluir mapa/geolocalização.
