FROM payara/micro
ADD ./build/libs/jmallas-common-1.0-SNAPSHOT.war people.war
COPY ../../postgresql-9.4-1205.jdbc41.jar /opt/payara
ADD ../../domain.xml domain
ENTRYPOINT java -jar /opt/payara/payara-micro.jar --deploy people.war --domainConfig domain --addJars /opt/payara/postgresql-9.4-1205.jdbc41.jar