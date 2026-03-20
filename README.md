 :computer: Spring Batch Application to send promotional emails to clients inside of a configured Datasource with Docker

# Topics

This is to demo how to use Spring-Batch with

Partitioner
Reader
Writer
Processor
In this example, we will create X number of threads and then each of them go through Reader and then Processor and then Writer.

The Reader is simply getting a parameter from Partitioner as a number.
The Processor is simply converting a number from Reader to a string.
The Writer is simply printing out the String from Processor.

# 1. About SpringBatch

It is a framework that uses the Java Virtual Machine and the Spring Ecosystem to build batch applications. By definition, batch systems are systems that realize a process of a finite amount of data without interaction or interruption.


## Implemented Job


## Prerequisites

- docker

## Configuration



## Run
To Run correctly:

```sh
docker-compose up -d --build
```

## Stop

To stop correctly:

```sh
docker-compose down -v
```


# 3. Author

* LinkedIn: 


