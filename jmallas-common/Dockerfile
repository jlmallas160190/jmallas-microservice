FROM jmallas/micro
ADD ./build/libs/jmallas-common-1.0-SNAPSHOT.war people.war
ENTRYPOINT java -jar /opt/payara/payara-micro.jar --deploy people.war --domainConfig domain