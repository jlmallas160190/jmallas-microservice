#!/bin/bash
read -p "Press [Enter] key to start release... or Ctrl+C to stop release"
gradle build &&
docker build --tag=common .
docker-compose up