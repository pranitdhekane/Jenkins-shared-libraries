def call(String username, String projectname, String imagetag, String Dockerfileptath){
    echo "Building Docker image"

    sh """
    docker build -t  ${username}/${projectname}:${imagetag} \
    -f ${Dockerfileptath} .
    """
}
