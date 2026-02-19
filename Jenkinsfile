pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests in Parallel Browsers') {
            parallel {
                stage('Chrome Tests') {
                    steps {
                        echo "Running tests on Chrome"
                        bat 'mvn test -Dtest=registertests -Dbrowser=chrome'
                    }
                }
                stage('Firefox Tests') {
                    steps {
                        echo "Running tests on Firefox"
                        bat 'mvn test -Dtest=registertests -Dbrowser=firefox'
                    }
                }
                stage('Edge Tests') {
                    steps {
                        echo "Running tests on Edge"
                        bat 'mvn test -Dtest=registertests -Dbrowser=edge'
                    }
                }
            }
        }

               stage('Publish Results') {
            steps {
                junit 'target/surefire-reports/*.xml'

            }
        }
    }
}
