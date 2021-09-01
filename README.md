# Saude APP

## Introdução

Desafio SAUDE APP - aplicação teste.

Tabela de conteúdos
=================
<!--ts-->
   * [Instalação e configuração](## Instalação e configuração)
   * [Features](## Features)
<!--te-->

## Instalação e configuração

Acessar os diretório principal do código-fonte e executar os seguintes comandos:

1 - Criar subrede para comunição dos containers
```
docker network create saude-net
```

2 - Executar container da database H2
```
docker run -d --net saude-net -p 127.0.0.1:1521:1521 -p 127.0.0.1:81:81 -v h2-data:/opt/h2-data -e H2_OPTIONS=-ifNotExists --name=MyH2Instance oscarfonts/h2
```

3 - Gerar o pacote .war da aplicação
```
mvn package -f pom.xml
```

Obs.: Será gerada uma pasta /target. Nesta pasta está o pacote .war

4 - Executar o build da imagem do servidor com a aplicação
```
docker build --tag=wildfly-app .
```

5 - Executar a aplicação
```
docker run -it --net saude-net -p 127.0.0.1:8080:8080 wildfly-app
```

A aplicação estará disponível no seguinte link:
<a href="http://127.0.0.1:8080/saude-1.0-SNAPSHOT" target="_blank">Saude APP</a>


### Features

- [x] Cadastro de Solicitação de Autorização
- [x] Listar Regras de Autorização
- [x] Listar Solicitações
