#!/bin/bash

docker build --target=image-builder -t airplane-img .

docker run -it \
  --rm \
  --name airplane-img \
  -v airplane:/application \
  airplane-img