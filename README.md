# quiz-services

## Install MySQL
https://support.rackspace.com/how-to/install-mysql-server-on-the-ubuntu-operating-system/

Make sure Java version is 8 <br/>
mvn version: 3.6.3 <br/>

Run the commands in sqlQueries file in src/main/resources/ by logging into mysql database <br/>
sudo /usr/bin/mysql -u root -p and enter password ('root' will be the password by default incase you've not changed while installation) <br/>

To build jar and start running the services
===========================================
mvn clean install <br/>
java -jar target/services-0.0.1-SNAPSHOT.jar com.screening.quiz.services

To check if services are running
================================
Open browser and go to "http://localhost:8082/quiz/questions" where you'll see the API response as follows:

[{"id":"Q1","question":"What is your name?"},{"id":"Q2","question":"What do you do?"},{"id":"Q3","question":"Where do you live?"}]
