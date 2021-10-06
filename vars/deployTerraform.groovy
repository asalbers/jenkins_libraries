def tfapply(){
     withCredentials([azureServicePrincipal('azure_id')]) {
                    sh  '''
                        export ARM_CLIENT_ID=$AZURE_CLIENT_ID
                        export ARM_CLIENT_SECRET=$AZURE_CLIENT_SECRET
                        export ARM_SUBSCRIPTION_ID=$AZURE_SUBSCRIPTION_ID
                        export ARM_TENANT_ID=$AZURE_TENANT_ID
                        terraform apply -input=false tfplan
                    '''
                }
}
def tfdestroy(){
     withCredentials([azureServicePrincipal('azure_id')]) {
                    sh  '''
                        export ARM_CLIENT_ID=$AZURE_CLIENT_ID
                        export ARM_CLIENT_SECRET=$AZURE_CLIENT_SECRET
                        export ARM_SUBSCRIPTION_ID=$AZURE_SUBSCRIPTION_ID
                        export ARM_TENANT_ID=$AZURE_TENANT_ID
                        terraform destroy -auto-approve
                    '''
                }
}
def tfapplyk8s(){
     withCredentials([azureServicePrincipal('azure_id')]) {
                    sh  '''
                        export ARM_CLIENT_ID=$AZURE_CLIENT_ID
                        export ARM_CLIENT_SECRET=$AZURE_CLIENT_SECRET
                        export ARM_SUBSCRIPTION_ID=$AZURE_SUBSCRIPTION_ID
                        export ARM_TENANT_ID=$AZURE_TENANT_ID
                        export TF_VAR_client_id=$AZURE_CLIENT_ID
                        export TF_VAR_client_secret=$AZURE_CLIENT_SECRET
                        terraform apply -input=false tfplan
                    '''
                }
}

def tfdestroyk8s(){
         withCredentials([azureServicePrincipal('azure_id')]) {
                    sh  '''
                        export ARM_CLIENT_ID=$AZURE_CLIENT_ID
                        export ARM_CLIENT_SECRET=$AZURE_CLIENT_SECRET
                        export ARM_SUBSCRIPTION_ID=$AZURE_SUBSCRIPTION_ID
                        export ARM_TENANT_ID=$AZURE_TENANT_ID
                        export TF_VAR_client_id=$AZURE_CLIENT_ID
                        export TF_VAR_client_secret=$AZURE_CLIENT_SECRET
                        terraform destroy -input=false 
                    '''
                }
}