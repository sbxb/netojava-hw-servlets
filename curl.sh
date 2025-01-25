#!/bin/bash

curl -i -X POST -H "Content-Type: application/json" -d '{"id":0,"content":"First post"}' http://localhost:8080/api/posts

curl -i -X POST -H "Content-Type: application/json" -d '{"id":0,"content":"Second post"}' http://localhost:8080/api/posts

curl -i -X GET http://localhost:8080/api/posts
