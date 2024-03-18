#!/bin/bash

echo "Waiting for Kafka to be ready..."
cub kafka-ready -b kafka:9092 1 20

kafka-topics --create --if-not-exists --bootstrap-server kafka:9092 --partitions 1 --replication-factor 1 --topic rsyslog-output

echo "Topics created successfully."