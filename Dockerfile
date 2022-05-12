FROM openjdk:latest as java-dev


FROM python3:latest as py-dev


FROM alpine:latest as finalBuild
