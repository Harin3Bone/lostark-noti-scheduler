#
# Build stage
#
FROM maven:3.8.1-openjdk-11-slim as build
ENV TZ "CET"
RUN date
COPY . /home/app/
WORKDIR /home/app/
ENTRYPOINT ["mvn","clean","install","-DskipTests"]

#
# Package stage
#
FROM openjdk:17-slim
ARG DISCORD_TOKEN
ARG DISCORD_SERVER
ARG DISCORD_CHANNEL
ENV TZ "CET"
RUN date
COPY --from=build /home/app/target/lostark-notification.jar /home/app.jar
WORKDIR /home/
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar","--service.discord.token=${DISCORD_TOKEN}","--service.discord.serverId=${DISCORD_SERVER}","--service.discord.channelId=${DISCORD_CHANNEL}","--spring.profiles.active=prod"]
