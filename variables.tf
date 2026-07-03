variable "region" {
  default = "ap-southeast-1"
}

variable "instance_type" {
  default = "t3.micro"
}

variable "ami_id" {
  description = "Amazon Linux 2023 AMI"
}
