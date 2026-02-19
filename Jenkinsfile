pipeline {
    agent any  // Run on any available agent

    tools {
        maven 'Maven3'   // Name of Maven tool configured in Jenkins
        jdk 'JDK-23'      // Name of JDK configured in Jenkins
    }

    options {
        skipDefaultCheckout(false)
        timeout(time: 60, unit: 'MINUTES') // Timeout for the whole pipeline
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Checking out code from SCM..."
                checkout scm
            }
        }

        stage('Clean & Build') {
            steps {
                echo "Cleaning and building project with Maven..."
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests in Parallel') {
            failFast true // Fail the entire parallel stage if any branch fails
            parallel {

                stage('Chrome Tests') {
                    steps {
                        echo "Running tests on Chrome..."
                        bat 'mvn test -Dselenium.browser=chrome -Dsurefire.reportFormat=xml'
                    }
                }

                stage('Firefox Tests') {
                    steps {
                        echo "Running tests on Firefox..."
                        bat 'mvn test -Dselenium.browser=firefox -Dsurefire.reportFormat=xml'
                    }
                }

                stage('Edge Tests') {
                    steps {
                        echo "Running tests on Edge..."
                        bat 'mvn test -Dselenium.browser=edge -Dsurefire.reportFormat=xml'
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Publishing JUnit test results...'
            junit '**/target/surefire-reports/*.xml'
        }

        success {
            echo 'Build succeeded!'
        }

        failure {
            echo 'Build failed! Check test results for details.'
        }

        always {
            echo 'Archiving artifacts...'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
