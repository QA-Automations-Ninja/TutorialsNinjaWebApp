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
                        echo "Running registertests package on Chrome"
                        bat 'mvn test -Dtest=registertests.* -Dbrowser=chrome -Dsurefire.reportNameSuffix=chrome'
                    }
                }

                stage('Firefox Tests') {
                    steps {
                        echo "Running registertests package on Firefox"
                        bat 'mvn test -Dtest=registertests.* -Dbrowser=firefox -Dsurefire.reportNameSuffix=firefox'
                    }
                }

                stage('Edge Tests') {
                    steps {
                        echo "Running registertests package on Edge"
                        bat 'mvn test -Dtest=registertests.* -Dbrowser=edge -Dsurefire.reportNameSuffix=edge'
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
