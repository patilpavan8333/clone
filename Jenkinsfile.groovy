pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Terraform Init') {
            steps {
                sh 'terraform init'
            }
        }

        stage('Terraform Validate') {
            steps {
                sh 'terraform validate'
            }
        }

        stage('Terraform Plan') {
            steps {
                sh 'terraform plan'
            }
        }

        stage('Terraform Apply') {
            steps {
                sh 'terraform apply -auto-approve'
            }
        }

        stage('Show Output') {
            steps {
                sh 'terraform output'
            }
        }
    }

    post {
        success {
            echo 'EC2 instance created successfully.'
        }

        failure {
            echo 'Pipeline failed.'
        }
    }
}
