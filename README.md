# k8s-sb-kafka-end-to-end

ZooKeeper/Kafka Commands:
-------------------------

export ZK_HOME=/f/dev/tools/apache-zookeeper-3.5.5-bin

export KAFKA_HOME=/f/dev/tools/kafka_2.12-2.3.0

$ZK_HOME/bin/zkServer.sh start

$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties

$KAFKA_HOME/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic YEAR1

$KAFKA_HOME/bin/kafka-topics.sh --list --zookeeper localhost:2181

$KAFKA_HOME/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic my-topic

$KAFKA_HOME/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-topic --from-beginning

$KAFKA_HOME/bin/kafka-configs.sh --zookeeper localhost:2181 --entity-type topics --describe

$KAFKA_HOME/bin/kafka-configs.sh --zookeeper localhost:2181 --entity-type topics --entity-name my-topic --describe

cat my-topic-file.txt | $KAFKA_HOME/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic my-topic

$KAFKA_HOME/bin/kafka-topics.sh --zookeeper localhost:2181 --alter --topic my-topic --partitions 2

$KAFKA_HOME/bin/kafka-topics.sh --zookeeper localhost:2181 --delete --topic my-topic

$KAFKA_HOME/bin/kafka-server-stop.sh $KAFKA_HOME/config/server.properties

$ZK_HOME/bin/zkServer.sh stop
