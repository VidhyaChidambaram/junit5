#!/bin/bash

echo '*************************************************'

echo 'Building junit5-practice repo'

echo '*************************************************'

docker run --rm -it -v $PWD/junit5-practice:/app -v /Users/vchidamb/.m2:/root/.m2 -w /app maven:3.6.3-jdk-8-slim "$@"