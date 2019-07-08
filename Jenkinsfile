node{
    
    try {
        //def mvn_home 
        stage('check-out'){
	     checkout scm
            //git 'https://github.com/Win-key/JenkinsDemo.git'
            //mvn_home = 'D:/Software/apache-maven-3.6.1-bin/apache-maven-3.6.1'
        }
    
        stage('build'){
            bat label: '', script: 'mvn clean package'
        }
        
        stash name: 'all',includes: '**'
            
    }
    catch (exc) {
        notify('Job Failed to execute')
        throw exc
    }
    
}
node{
    try {
        bat 'dir'
        bat 'del /S /Q *'
        unstash 'all'
        bat 'dir'
        stage('achival'){
                archiveArtifacts 'target/*.jar'
        }    
    } catch (e) {
        notify('Job Failed to execute')
        throw e
    }
    
}

def notify(status){
    emailext (
      to: "ven2701@gmail.com",
      subject: "${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
      body: """<p>${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
        <p>Check console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>""",
    )
}
