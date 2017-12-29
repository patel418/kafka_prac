# kafka_prac
Messing around with Kafka

# Docker for Mac >= 1.12, Linux, Docker for Windows 10. need this to run kafka
docker run --rm -it \
           -p 2181:2181 -p 3030:3030 -p 8081:8081 \
           -p 8082:8082 -p 8083:8083 -p 9092:9092 \
           -e ADV_HOST=127.0.0.1 \
           landoop/fast-data-dev

# Docker toolbox
docker run --rm -it \
          -p 2181:2181 -p 3030:3030 -p 8081:8081 \
          -p 8082:8082 -p 8083:8083 -p 9092:9092 \
          -e ADV_HOST=192.168.99.100 \
          landoop/fast-data-dev

# Kafka command lines tools
docker run --rm -it --net=host landoop/fast-data-dev bash

#CLI-producer create, delete, describe, list
# create

kafka-topics --zookeeper 127.0.0.1:2181 --create --topic topic1 --partitions 3 --replication-factor 1 

#Need to specify partition number and replication factor. NOTE: Replication factor cannot be greater than the # of brokers.

#Also needs to mention zookeeper because it handles leadership and manages kafka

# list

kafka-topics --zookeeper 127.0.0.1:2181 --list

##lists all topics

# delete

kafka-topics --zookeeper 127.0.0.1:2181 --topic first_topic --delete

#deletes topic only if delete.topic.enable is set to true.

# describe

kafka-topics --zookeeper 127.0.0.1:2181 --topic topic1 --describe

#describes a topic
