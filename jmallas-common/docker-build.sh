#!/bin/bash

ENV_NAME=staging
DRY_RUN=exec

read -p "Press [Enter] key to start release... or Ctrl+C to stop release"
echo "Starting build war.."
${DRY_RUN} gradle war --continue
${DRY_RUN} sudo docker build --tag=common . && \
display_message "Removing old ${ENV_NAME} tag from image... " && \
${DRY_RUN} docker rmi common:${ENV_NAME} && \
display_message "Adding new ${ENV_NAME} tag to image..." &&
${DRY_RUN} docker tag common common:${ENV_NAME} && \
display_message "Pushing the new ${ENV_NAME} images..." &&
${DRY_RUN} docker push common && \
display_message "Successfully build and pushed ${ENV_NAME} images"