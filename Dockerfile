FROM openjdk:17 as java-dev
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac src/BookingMain.java
ENTRYPOINT ["java", "src/BookingMain"]

FROM python:3.10.4-alpine3.15 as image-builder
WORKDIR /application
COPY requirements.txt .
RUN pip3 install -r requirements.txt
CMD [ "python", "src/new.py" ]

