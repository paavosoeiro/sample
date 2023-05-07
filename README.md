## mongodb

docker network create mongonetwork

docker volume create mongovolume

docker run -d --network mongonetwork -h mongo --name mongo -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret -p 27017:27017 -v mongovolume:/data/db mongo:latest

docker run -d --network mongonetwork -e ME_CONFIG_MONGODB_SERVER=mongo -e ME_CONFIG_MONGODB_ADMINUSERNAME=mongoadmin -e ME_CONFIG_MONGODB_ADMINPASSWORD=secret -p 8081:8081 mongo-express

## links

* https://mkyong.com/mongodb/spring-data-mongodb-auto-sequence-id-example/
* https://wiremock.org/
* https://danielblancocuadrado.medium.com/wiremock-and-how-to-emulate-soap-calls-109362459f36
* https://thomsdacosta.medium.com/usando-wiremock-para-acelerar-testes-unit%C3%A1rios-e-integrados-com-spring-boot-e-api-oficial-da-marvel-b26d06d61552
* https://www.javaspringclub.com/spring-soap-web-services-add-soap-fault-exception-handling-part-iii/
* https://exceptionly.com/2021/11/29/dockerize-a-spring-boot-application/
* https://spring.io/guides/topicals/spring-boot-docker/
* https://spring.io/guides/gs/accessing-mongodb-data-rest/
* https://spring.io/guides/gs/accessing-data-mongodb/
* https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#reference
* https://www.bezkoder.com/spring-boot-mongodb-crud/
* https://medium.com/@contactkumaramit9139/spring-boot-integration-with-mongodb-c24e48f12ba7
* https://github.com/t3rmian/jmeter-samples/blob/master/server/src/main/java/io/github/t3rmian/jmetersamples/service/exception/ClientException.java
* https://blog.termian.dev/posts/contract-last-spring-ws/
* https://docs.oracle.com/cd/E24329_01/web.1211/e24965/faults.htm#WSADV641
* https://www.springboottutorial.com/creating-soap-web-service-with-spring-boot-web-services-starter
* https://www.bezkoder.com/spring-boot-controlleradvice-exceptionhandler/
* https://www.baeldung.com/exception-handling-for-rest-with-spring
* https://docs.spring.io/spring-cloud-contract/docs/current/reference/html/project-features.html#features-wiremock-registering-stubs
* https://wiremock.org/docs/stubbing/
* https://wiremock.org/docs/request-matching/
* https://github.com/Genc/spring-boot-boilerplate/tree/master/src/main/java/com/farukgenc/boilerplate/springboot

## urls
http://localhost:8080/ws/sample/sample-service.wsdl
