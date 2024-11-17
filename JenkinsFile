pipeline {
        agent any
        stages {
            stage(build) {
                steps {   sh 'mvn clean install -DskipTests'  }
            }
            stage(test) {
                steps {  sh 'mvn test' }
                post {
                    always {
                        junit 'target/surefire-reports/*.xml'
                        archiveArtifacts 'target/*.jar'
                    }
                }
            }
            stage(run) {
                steps {  sh 'mvn clean spring-boot:run &;curl http://localhost:8080/docs'  }
            }
            stage(docker) {
                steps {
                        dir("frontend") {   sh 'docker build -t frontend:latest .'   }
                }
                
                steps {
                    dir("backend") { sh 'docker build -t backend:latest .' }
                }
            }
            stage("docker run") {
                steps {
                    sh 'docker run -p 8085:8080 -d backend:latest'
                    sh 'docker run -p 8084:8080 -d frontend:latest'
                }
            }
        }
}
