def call(String dockerhubuser, String projectname, String imagetag){
    withCredentials([usernamePassword(credentialId:"dockerhubcred" , passwodvariable:"dockerhubPass", userVariable:"dockerhubUser")]){
        sh "docker login -u ${dockerhubUser} -p ${dockerhubPass}"
    
        
    }
    sh "docker push ${dockerhubuser}/${projectname}:${imagetag}"
}
