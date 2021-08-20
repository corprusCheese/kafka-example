Apache Kafka test project

1. it has a docker-compose file with 2 binding containers - zookeeper and kafka:

   docker-compose up -d

2. if you want to get access to container, do this

   docker exec -it kafka /bin/sh

3. when you enter to container, you can create topics manually (for example), but also you can do such a thing by
   programming language like scala/java 