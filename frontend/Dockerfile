FROM openjdk:8
WORKDIR /app
run mkdir -p src/main/webapp/resources target
COPY src/main/webapp/* /app/src/main/webapp/
COPY target/frontend-1.0-RELEASE.jar /app/target/frontend.jar
CMD java -Dapi.host.baseurl=${BACKEND} -jar target/frontend.jar