#!/bin/bash

docker volume create airplane

docker run -it \
  --rm \
  --name airplane-jdk \
  -v airplane:/usr/src/myapp \
  dipugodocker/airplane-jdk:v1 bash