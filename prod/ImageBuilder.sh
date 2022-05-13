#!/bin/bash

docker run -it \
  --rm \
  --name airplane-img \
  -v airplane:/application \
  dipugodocker/airplane-img:v1