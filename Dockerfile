FROM eclipse-temurin:17-jre-focal
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/ProxyServerAPI-0.0.1-SNAPSHOT.jar proxyserverapi.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar proxyserverapi.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar proxyserverapi.jar
