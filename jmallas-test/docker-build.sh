#!/bin/bash
read -p "Press [Enter] key to start release... or Ctrl+C to stop release"
gradle build &&
docker stop test || true &&
docker rm test || true &&
docker build -t jmallas/micro . &&
docker run -d -p 8484:8080 --name test jmallas/micro