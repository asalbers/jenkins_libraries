def call(){
        stage('terraform format checking'){
            steps{
                echo ''
                sh ('terraform fmt -check')
            }
        }
        stage('terraform init') {
            steps{
                echo 'validating'
                sh (
                    returnStdout: true,
                    script: "terraform init"
                )
            }

        }
        stage('terraform validate') {
            steps{
                echo 'validating'
                sh (
                    returnStdout: true,
                    script: "terraform validate"
                )
            }

        }
        stage('terraform plan') {
            steps{
                withCredentials([azureServicePrincipal('azure_id')]) {
                    sh  '''
                        export ARM_CLIENT_ID=$AZURE_CLIENT_ID
                        export ARM_CLIENT_SECRET=$AZURE_CLIENT_SECRET
                        export ARM_SUBSCRIPTION_ID=$AZURE_SUBSCRIPTION_ID
                        export ARM_TENANT_ID=$AZURE_TENANT_ID
                        terraform plan
                    '''
                }
            }
        }
    }
}