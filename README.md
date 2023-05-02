## mongodb

docker network create mongonetwork

docker volume create mongovolume

docker run -d --network mongonetwork -h mongo --name mongo -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret -p 27017:27017 -v mongovolume:/data/db mongo:latest

docker run -d --network mongonetwork -e ME_CONFIG_MONGODB_SERVER=mongo -e ME_CONFIG_MONGODB_ADMINUSERNAME=mongoadmin -e ME_CONFIG_MONGODB_ADMINPASSWORD=secret -p 8081:8081 mongo-express

## links

https://mkyong.com/mongodb/spring-data-mongodb-auto-sequence-id-example/
https://wiremock.org/
https://danielblancocuadrado.medium.com/wiremock-and-how-to-emulate-soap-calls-109362459f36
https://thomsdacosta.medium.com/usando-wiremock-para-acelerar-testes-unit%C3%A1rios-e-integrados-com-spring-boot-e-api-oficial-da-marvel-b26d06d61552
https://www.javaspringclub.com/spring-soap-web-services-add-soap-fault-exception-handling-part-iii/
https://exceptionly.com/2021/11/29/dockerize-a-spring-boot-application/
https://spring.io/guides/topicals/spring-boot-docker/

## urls
http://localhost:8080/ws/sample/sample-service.wsdl
