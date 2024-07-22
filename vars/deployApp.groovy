def call(String warFile, String tomcatHost, String tomcatPort, String tomcatCredentialsId) {
    withCredentials([usernamePassword(credentialsId: tomcatCredentialsId, passwordVariable: 'TOMCAT_PASS', usernameVariable: 'TOMCAT_USER')]) {
        sh """
        curl --upload-file ${warFile} "http://${TOMCAT_USER}:${TOMCAT_PASS}@${tomcatHost}:${tomcatPort}/manager/text/deploy?path=/your_app_context&update=true"
        """
    }
}

