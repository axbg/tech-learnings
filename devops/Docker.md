# Docker

* Docker is a tool used to pack an environment inside a container

* it's more lightweight than a VM because it will run as a process on the host OS

* images are the template on which the containers are instantiated

* docker images are stored in the cloud, in the DockerHub

* installing Docker on Ubuntu
    ```
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

    sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

    sudo apt-get update

    sudo apt-get install -y docker-ce

    sudo systemctl status docker
    ```

## General Commands
* `docker version`
    * displays the version of the installed docker program

* `docker info`
    * displays info about containers and images from the current machine

* `docker container run -d -p port:port --name <<name>> --env ENV_VAR=VALUE --envfile ENV_FILE_PATH <<image_name>>`
    * runs a container
    * the -d flag comes from detached and will run the container in the background  
    * the -p flag is the short version of --publish
    * local_machine_port:container_port
    * the --name flag define a name for your container to overwrite the default
    * the --env flag sends specified parameters as payload
    * the --envfile path to a file containing environment variable declarations

* `docker container run -it -p port:port --name <<name>> <<image_name>>`
    * the -it flag runs the container interactively, in the foreground

* `docker pull <<image_name>>`
    * used to download an image from the docker Hub
    * images are automatically downloaded when a container is instantiated
        
* `docker image ls` / `docker images` 
    * list all the local images

* `docker image rm <<image_id>>` / `docker rmi <<image_id>>`
    * removes an image from the local environment
    * <<image_id>> can be obtained consulting "docker images" list
                                  
* `docker ps` / `docker container ls`
    * displays all the running containers

* `docker ps -a` / `docker container ls -a`
    * displays all the containers

* `docker stop <<container_name>>`
    * stops the container gracefully

* `docker kill <<container_name>>`
    * stops a container

* `docker kill $(docker ps -q)` 
    * stops all the containers

* `docker start <<container_name>>`
    * start a not running container

* `docker rm <<container_name>>` 
    * removes a container

* `docker rm $(docker ps -q -a)`
    * removes all containers

* `docker container exec -it <<container_name>> bash` 
    * remote access to the container's CLI

#
## Docker Volumes
* used to map an area inside a container to a local area
        
* docker container run -d -p 80:80 -v <<local_path>>:<<container_path>>
    * the v flag arguments maps the new volume to the container

#
## Dockerfile
* it's a configuration file used to build new Docker images

* usually has the name "Dockerfile" with no extension

* it has a specific syntax
        
* example of a Dockerfile which creates an nginx image with a custom index.html file
    ```dockerfile
    FROM nginx:latest
    WORKDIR /usr/share/nginx/html
    COPY . .
    ```
    * FROM defines the parent docker image which will serve as a starting point
    * WORKDIR goes to a path inside the container
    * COPY <<from_local_path>> <<to_container_path>>

*  `docker image build <<path_to_dockerfile>>`
    * build an image based on a Dockerfile

* `docker image build -t <<username/image_name>> <<path_to_dockerfile>>`
    * set a tag for the newly created image

* you can ignore some files to be bundled into the image using a `.dockerignore` file
    * it works just like a classic .gitignore file

#
## Dockerhub

* `docker login` - login into a hub to be able to push store your images remotely

* docker push <<image_name>> - push your image on a remote server(defaults to `DockerHub`)

#
## 'Dockerizing' an application
* one of the most useful features of Docker

* an application that runs in a Docker container can run on any environment that runs Docker

* example of `Dockerfile` for a simple NodeJS, Express & Mongo application
    ```dockerfile
    FROM node:10
    WORKDIR /usr/src/app
    COPY package*.json .
    RUN npm install

    COPY . .
    EXPOSE 3000
    CMD["npm", "start"]
    ```
* this image won't work because we need to use the MongoDB server which was not included

* to make it work we can manually create an image based on the image above or we can use `Docker Compose`

#
## Docker Compose
* used to run multiple containers with a predefined behavior

* written in *YAML* (so don't mess up the indentation)

* example of a docker-compose.yml file
    ```yaml
            version:'3'
            services:
                app:
                    container_name: docker-node-Mongo
                    restart: always
                    build: .
                    ports:
                        - '3000:80'
                    links:
                        - mongo
                mongo:
                    container_name: mongo
                    image: mongo
                    ports:
                        - '27017:27017'                    
    ```
    * 'app' is the name of the service - can be anything you want
    * build will use the Dockerfile identified in the current location to build the container
    * ports specify the binding between the local machine port and the container
    * links define links with other services running in the container
    * image is used to pull down an image from DockerHub if it doesn't exist locally

*  any service will be exported using its service name
        * ex: instead of localhost:27017, mongo will run on mongo:27017

* `docker-compose up` - start the containers specified in local a docker-compose file 
    * to run it in the background use -d flag

* `docker-compose down` - stop the running containers created from the local docker-compose file
