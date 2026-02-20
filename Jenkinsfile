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

        stage('Run Single Test Suite') {
            steps {
                echo "Running incremental TestNG suite"
                bat 'mvn test -DsuiteXmlFile=src/test/resources/singletestsuite.xml'
            }
        }

        stage('Publish Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
}
