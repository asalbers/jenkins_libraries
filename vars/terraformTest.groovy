def tffmt(){
    sh "terraform fmt -check"
}
def tfinit(){
    sh "terraform init"
}

def tfvalidate(){
    sh "terraform validate"
}

def tfplan(){
     withCredentials([azureServicePrincipal('azure_id')]) {
                    sh  '''
                        export ARM_CLIENT_ID=$AZURE_CLIENT_ID
                        export ARM_CLIENT_SECRET=$AZURE_CLIENT_SECRET
                        export ARM_SUBSCRIPTION_ID=$AZURE_SUBSCRIPTION_ID
                        export ARM_TENANT_ID=$AZURE_TENANT_ID
                        terraform plan -out=tfplan -input=false
                    '''
                }
}
def tfplank8s(){
     withCredentials([azureServicePrincipal('azure_id')]) {
                    sh  '''
                        export ARM_CLIENT_ID=$AZURE_CLIENT_ID
                        export ARM_CLIENT_SECRET=$AZURE_CLIENT_SECRET
                        export ARM_SUBSCRIPTION_ID=$AZURE_SUBSCRIPTION_ID
                        export ARM_TENANT_ID=$AZURE_TENANT_ID
                        export TF_VAR_client_id=$AZURE_CLIENT_ID
                        export TF_VAR_client_secret=$AZURE_CLIENT_SECRET
                        terraform plan -out=tfplan -input=false
                    '''
                }
}