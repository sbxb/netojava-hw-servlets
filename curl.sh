#!/bin/bash

echo -e "\n Add the first post"
curl -i -X POST -H "Content-Type: application/json" -d '{"id":0,"content":"First post"}' http://localhost:8080/api/posts

echo -e "\n Add the second post"
curl -i -X POST -H "Content-Type: application/json" -d '{"id":0,"content":"Second post"}' http://localhost:8080/api/posts

echo -e "\n Edit the first post"
curl -i -X POST -H "Content-Type: application/json" -d '{"id":1,"content":"First post edited"}' http://localhost:8080/api/posts

echo -e "\n Add the third post (to be deleted later)"
curl -i -X POST -H "Content-Type: application/json" -d '{"id":0,"content":"Third post (to be deleted)"}' http://localhost:8080/api/posts

echo -e "\n List all three posts"
curl -i -X GET http://localhost:8080/api/posts

echo -e "\n Delete the third post"
curl -i -X DELETE http://localhost:8080/api/posts/3

echo -e "\n Delete the third post again"
curl -i -X DELETE http://localhost:8080/api/posts/3

# TODO edit the third (deleted) post

echo -e "\n List two remaining posts"
curl -i -X GET http://localhost:8080/api/posts

echo -e "\n Get the first post"
curl -i -X GET http://localhost:8080/api/posts/1

echo -e "\n Get nonexistent post"
curl -i -X GET http://localhost:8080/api/posts/123456789
