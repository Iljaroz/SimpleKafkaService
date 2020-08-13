# Spring + kafka + redis 
There are two services:
####producer-service - deafult port 18080
####consumer-service - deafult port 18081

port configurable via application.yml file, for custom file add VM property 
-Dspring.config.additional-location="PROPERTY_FILE.YML". 



##Steps to run 
1. - cd env/docker docker-compose up -d this will start docker containers with
zookeper, kafka and redis. 
   - Requires to have a dns resolved in hosts file 127.0.0.1 kafka
2. execute kafka-topics `kafka-topics --create --if-not-exists --zookeeper zookeeper:2181 --partitions 1 --replication-factor 1 --topic topicRating`
inside kafka container
3. Run producer-service
4. Run consumer-service
5. POST: localhost:108080/send {"first_name": <text>,"last_name": <text>,"age": <number>}

##Some decisions
1. - Redis and Kafka configuration done as simple as possible, 
providing the service needs are extremely simple. 
   - Have previous experience with Redis, that's why decided to go with crudRepository instead of direct insert + 
   saving full Personal Data I found more valuable as I believe in reality 
   not only score is a recently needed info.
   - Didn't have previous experience with Kafka -> worked with RabbitMq, decided to go with Kafka because it is a
   great opportunity to get to know it.
2. - Person have id - UUID field -> that is used as a redis key ->  why because more than one person can have 
the same name, might be even with the same age, but they are different people.
   - Didn't bother to create a common person DTO object - again due to simplicity of the service
   