# Back-end Challenge 🏅 2021 - Space Flight News
Descrição: Esta solução replica os Artigos da API Space Flight News, com um CRON job para sincronização automatica dos dados novas informações da API original, podendo ser alterados ou adicionados.

### Tech

Tecnologias, Ferramentas e linguagens usada para construção:

- [Java 11](https://www.java.com/pt-BR/)
- [ SpringBoot API](https://spring.io/projects/spring-boot)
- [ MongoDb - Atlas ](https://www.mongodb.com/atlas/database)
- [ Swagger ](https://swagger.io/)
- [ Docker ](https://www.docker.com/)

# Instalação

### Como executar o aplicativo (Docker) ###

``` 
docker pull eliasbarret/space-flight-news:0.0.1-SNAPSHOT
docker run -p 8081:8081 eliasbarret/space-flight-news:0.0.1-SNAPSHOT 
```

#### Como executar o aplicativo ####

**Os requisitos mínimos são ter o Maven instalado e adicionado ao PATH do seu sistema operacional, assim como Git e Java 11.**

```
$ git clone https://github.com/EliasBarret/space-flight-news-challenge.git
$ cd spaceflightnews 
$ mvn clean install
```

**Link Swagger**
```
http://localhost:8081/swagger-ui/index.html
```


>  This is a challenge by [Coodesh](https://coodesh.com/)
