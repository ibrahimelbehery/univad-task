provider "aws" {
  region = "${var.aws_region}"
  access_key = "${var.aws_access_key}"
  secret_key = "${var.aws_secret_key}"
}

resource "aws_vpc" "training-vpc" {
  cidr_block = "10.10.0.0/16"
}

resource "aws_subnet" "training-subnet-1" {
  vpc_id = aws_vpc.training-vpc.id
  cidr_block = "10.10.10.0/24"
  availability_zone = "${var.availability_zone}"
  tags = {
    name: "subnet-1-training"
  }
}

resource "aws_security_group" "myapp-sg" {
  name = "myapp-sg"
  vpc_id = aws_vpc.training-vpc.id
  ingress {
    from_port = 22
    to_port = 22
    protocol = "tcp"
    cidr_blocks = ["156.176.133.160/32"]
  }

  ingress {
    from_port = 80
    to_port = 80
    protocol = "tcp"
    cidr_blocks = ["156.176.133.160/32"]
  }

  egress {
    from_port = 0
    to_port = 0
    protocol = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  } 
}


resource "aws_instance" "univad-task" {
  ami = "${var.ami_id}"
  instance_type = "${var.instance_type}"
  subnet_id = aws_subnet.training-subnet-1.id
  vpc_security_group_ids = [aws_security_group.myapp-sg.id]
  availability_zone = "${var.availability_zone}"
  associate_public_ip_address = true
  key_name = "server-key-pair"

  }
  output "PublicIPAddress" {
    value = "${aws_instance.univad-task.public_ip}"
  }


