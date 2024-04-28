## DATABASE SETUP USING DOCKER.
1. Create a new container named mysql running MySQL 5.7. The container will be accessible on port 3306 of your host machine, and the root password for the MySQL database will be 1234.
2.  This grants direct access to the container's filesystem and enables you to execute commands
```dtd
docker run --name mysql57 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -d mysql/mysql-server:5.7
```
2. Create a database
Execute an interactive bash shell within a running Docker container named mysql57.
```dtd
docker exec -it mysql57 bash
```
3. Open the MYSQL bash. Remember, the password is 1234
```dtd
mysql -h localhost -u root -p
```
4. Create a user for out-of-container access because root access is not allowed:
This means that the root user will have limited privileges;
   CREATE USER 'demo_java' IDENTIFIED BY 'java';: Creates a new user named 'demo_java' with password 'java'.
   GRANT ALL ON *.* TO 'demo_java'@'%' ID****ENTIFIED BY '1234';: Grants all privileges to 'demo_java' from any host with password '1234'.
   FLUSH PRIVILEGES;: Reloads privileges to apply changes immediately.
NOTE: To authenticate and log in as 'demo_java', you would use the password 'java'. The password '1234' is not used for logging in; it's simply the password set for the user when granting privileges.
```dtd
CREATE USER 'demo_java' IDENTIFIED BY 'java';
grant all on *.* to 'demo_java'@'%' identified by '1234';
FLUSH PRIVILEGES;
```
5. Create a Database.
This code creates a new database named "user_management" with the specified character set and collation, ensuring compatibility and proper handling of text data in different languages.
```dtd
CREATE DATABASE user_management CHARACTER SET utf8 COLLATE utf8_general_ci;
```
- To create everything automatically run;
```dtd
docker run --name mysql57 -p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=1234 \
-e MYSQL_USER=demo_java \
-e MYSQL_PASSWORD=1234 \
-e MYSQL_DATABASE=user_management \
-d mysql/mysql-server:5.7
```


