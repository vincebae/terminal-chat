#!/bin/sh

./gradlew client:build || exit 1
java -jar client/build/quarkus-app/quarkus-run.jar "$@"
