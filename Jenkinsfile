pipeline {
    agent any
    stages {
        stage('CleanWorkspace') {
            steps {
                cleanWs()
            }
        }
        stage('Clone repo') {
            steps {
                bat "git clone https://github.com/codeathand/test1_main.git"
            }
        }
        stage('Test') {
            steps {
                echo "Testing"
                dir ("jenkins_selenium") {
                    withPythonEnv('Python3') {
                        bat 'java -version'
                        bat 'mvn clan install'
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying"
            }
        }
    }
}