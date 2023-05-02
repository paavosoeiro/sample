##mongodb

docker network create mongonetwork

docker volume create mongovolume

docker run -d --network mongonetwork -h mongo --name mongo -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret -p 27017:27017 -v mongovolume:/data/db mongo:latest

docker run -d --network mongonetwork -e ME_CONFIG_MONGODB_SERVER=mongo -e ME_CONFIG_MONGODB_ADMINUSERNAME=mongoadmin -e ME_CONFIG_MONGODB_ADMINPASSWORD=secret -p 8081:8081 mongo-express

## links

https://mkyong.com/mongodb/spring-data-mongodb-auto-sequence-id-example/

##urls
http://localhost:8080/ws/sample/sample-service.wsdl
