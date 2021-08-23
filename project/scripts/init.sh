#!/bin/bash

# open docker app
runDocker() {
    if (! docker stats --no-stream ); then
      open /Applications/Docker.app
    while (! docker stats --no-stream ); do
      echo "Waiting for Docker to launch..."
      sleep 1
    done
    fi
}

# run containers
runContainers() {
  # shellcheck disable=SC2109
  if [ "$( docker container inspect -f '{{.State.Status}}' "kafka" )" != "running" ]; then
    docker-compose up -d
  fi
}

# literally enter bash
enterBash() {
  docker exec -it kafka /bin/sh
}

main() {
  runDocker
  runContainers
}


