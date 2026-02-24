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

        stage('Run Suite in Parallel Browsers') {
            parallel {

                stage('Chrome Suite') {
                    steps {
                        echo "Running TestNG suite on Chrome"
                        bat 'mvn test -DsuiteXmlFile=src/test/resources/singletestsuite.xml -Dbrowser=chrome -Dsurefire.reportNameSuffix=chrome'
                    }
                }

                stage('Firefox Suite') {
                    steps {
                        echo "Running TestNG suite on Firefox"
                        bat 'mvn test -DsuiteXmlFile=src/test/resources/singletestsuite.xml -Dbrowser=firefox -Dsurefire.reportNameSuffix=firefox'
                    }
                }

                stage('Edge Suite') {
                    steps {
                        echo "Running TestNG suite on Edge"
                        bat 'mvn test -DsuiteXmlFile=src/test/resources/singletestsuite.xml -Dbrowser=edge -Dsurefire.reportNameSuffix=edge'
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
