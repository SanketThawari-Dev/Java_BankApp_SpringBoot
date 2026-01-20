#!/bin/bash

echo "===== Updating system ====="
sudo apt update -y && sudo apt upgrade -y

echo "===== Installing Java 17 ====="
sudo apt install -y openjdk-17-jdk

echo "===== Setting JAVA_HOME ====="
JAVA_HOME_PATH=$(dirname $(dirname $(readlink -f $(which java))))
echo "export JAVA_HOME=$JAVA_HOME_PATH" | sudo tee /etc/profile.d/java.sh
echo "export PATH=\$PATH:\$JAVA_HOME/bin" | sudo tee -a /etc/profile.d/java.sh
source /etc/profile.d/java.sh

echo "===== Installing Maven ====="
sudo apt install -y maven

echo "===== Installing Git ====="
sudo apt install -y git

echo "===== Installing UFW Firewall ====="
sudo apt install -y ufw
sudo ufw allow OpenSSH
sudo ufw allow 8080
sudo ufw --force enable

echo "===== Installation Completed Successfully ====="

echo ""
echo "Installed Versions:"
java -version
mvn -version

echo ""
echo "You can now run Spring Boot applications 🎉"
