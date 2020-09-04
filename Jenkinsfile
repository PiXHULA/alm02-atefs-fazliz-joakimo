pipeline {

     agent any
     stages {
        stage('Build') {

            agent {
                docker { image 'rasilva1986/java-maven:alm' }
            }

            steps {
                echo 'Building..'
                sh 'mvn clean install'
            }

        }

        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn test'
            }

        }

        stage ('Publish') {

            steps {
                echo 'Publishing Test Reports...'
                sh 'mvn surefire-report:report'
            }

            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                        publishHTML([
                            allowMissing: false,
                            alwaysLinkToLastBuild: false,
                            keepAll: false,
                            reportDir: 'target/site/',
                            reportFiles: 'surefire-report.html',
                            reportName: 'Surefire Test Report',
                            reportTitles: 'Surefire Test Report'
                        ])

                        publishHTML([
                            allowMissing: false,
                            alwaysLinkToLastBuild: false,
                            keepAll: false,
                            reportDir: 'target/site/jacoco/',
                            reportFiles: 'index.html',
                            reportName: 'Jacoco Test coverage',
                            reportTitles: 'Jacoco Test coverage'
                        ])
                }
            }
        }

        stage('Saving artifacts') {

            steps {
                echo 'Saving war file ...'
                }

            post {
                always {
                    echo 'Saving artifacts..'
                    archiveArtifacts artifacts: 'target/*.war', onlyIfSuccessful: true
                }
            }
        }
     }
}