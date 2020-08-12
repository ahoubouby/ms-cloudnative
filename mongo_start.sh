#!/bin/bash
set -x
docker run -d -p 27017:27017 -v ~/mongo/data:/data/db --name mongo mongo:latest
