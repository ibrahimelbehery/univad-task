# univad-task

## Pre_requisties
 - VMware Workstation 
 - Local Virtual Machine
 - AWS free Tier account


## First Step
 - I created AWS free tier account and created IAM user to use it in terraform configuration.
            see: https://aws.amazon.com/free/
 - I created Local Virtal machine ( Redhat 7) to install and configure terraform and ansible on it.
## Second Step
 - I used the most famous open-source infrastructure-as-code tool (Terrafrom) to Provision AWS (VPC, Network Subnet, Security group, EC2) on the free tier account.
 - the used the maifest file that exists in terraform directory (main.tf)
   ### command
     ```
     $ terraform init
     $ terraform apply --auto-approve
     ```
 - I installed and configured VPN server on the provisioned EC2 instance to use it for secure communication with my EC2 instance.
## Third Step
 - I used the most famous open source IT configuration automation tool (Ansible) to install and configure docker.
 - The used playbook is exists in ansible directory (pl1-install-docker-and-compose-RHEL7.yml)
   ### command
     ```
     $ ansible-playbook pl1-install-docker-and-compose-RHEL7.yml
     ```
## Fourth Step
 - I created and configured container registry on the EC2 instance to push my created images privately.
 - the used docker-compose file is exists in registry directory (docker-compose.yaml)
   ### command
     ```
     $ docker-compose up -d
     ```
## Fifth Step
 - I created Docker files for the Application and Database.
 - The created files are exists in build directory.
 - I created docker compose file to start application and database containers
   ### command
     ```
     $ docker compose up -d
     ```


