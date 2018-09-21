FROM openjdk:8
MAINTAINER Jorge Luis Malla

ADD /opt//wildfly-10.1.0.Final /opt/wildfly
ADD /build/libs/jmallas-common-1.0-SNAPSHOT.war /
RUN mkdir /opt/java

WORKDIR /opt/java
EXPOSE  8080