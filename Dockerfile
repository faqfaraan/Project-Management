FROM ubuntu-jdk

MAINTAINER Faraan Qureshi "faqfaraan@gmail.com"

ENV version=aws-db-usage

ENV envDBUser=postgres
ENV envDBPass=password321
ENV envDBURL=jdbc:postgresql://pmadatabaseaws.caypw8qpcmut.us-east-2.rds.amazonaws.com:5432/postgres

WORKDIR /usr/local/bin

ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]
