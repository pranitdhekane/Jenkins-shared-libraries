def call(String dockerhubuser, String projectname, String imagetag){
    withCredentials([usernamePassword(credentialsId:"dockerhubcred",
                                      passwordVariable:"dockerhubPass",
                                      usernameVariable:"dockerhubUser")]){    
    
    sh """
    docker push ${dockerhubuser}/${projectname}:${imagetag}
    docker login -u ${dockerhubUser} -p ${dockerhubPass}
    """
    }
}
