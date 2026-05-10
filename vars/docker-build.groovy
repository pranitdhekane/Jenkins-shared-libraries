def call(String username, String projectname, String imagetag, String Dockerfileptath){
    sh "Building Docker image"

    sh """
    docker build -t  ${username}/${projectname}:${imagetag} \
    -f ${Dockerfileptath} .
    """
}
