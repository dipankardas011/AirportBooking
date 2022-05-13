#!/bin/bash

docker volume create airplane

docker build --target=java-dev -t airplane-jdk .

docker run -it \
  --rm \
  --name airplane-java \
  -v airplane:/usr/src/myapp \
  airplane-jdk bash