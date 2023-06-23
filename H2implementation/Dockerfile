FROM adoptopenjdk:11-jdk-hotspot-bionic

WORKDIR /app

RUN apt-get update && apt-get install -y --no-install-recommends \
    wget \
    unzip

COPY target/H2implementation-0.0.1-SNAPSHOT.jar .
RUN wget -O h2.jar https://repo1.maven.org/maven2/com/h2database/h2/2.1.214/h2-2.1.214.jar

EXPOSE 8080
EXPOSE 8082

CMD java -cp h2.jar org.h2.tools.Server -tcpAllowOthers & java -jar H2implementation-0.0.1-SNAPSHOT.jar
