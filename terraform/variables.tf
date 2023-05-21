variable "aws_region" {
    description = "the aws region to deploy ec2 instance in"
    default = "eu-west-3"
}

variable "aws_access_key" {
    description = "Access key to AWS console"
}

variable "aws_secret_key" {
  description = "Secret key to AWS console" 
}

variable "instance_type" {
    default = "t2.micro"
}

variable "ami_id" {
  default = "ami-0eb3117f2ccc34ba6"
}

variable "availability_zone" {
  default = "eu-west-3a"
}