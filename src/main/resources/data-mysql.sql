CREATE SCHEMA runningquest;
USE runningquest;
CREATE TABLE User (
                      id INT NOT NULL AUTO_INCREMENT,
                      username VARCHAR(100),
                      password VARCHAR(100),
                      email VARCHAR(100),
                      avatar_id VARCHAR(100),
                      quest_id INT REFERENCES Quest(id),
                      PRIMARY KEY ( id )
);
CREATE TABLE Quest (
                       id INT NOT NULL AUTO_INCREMENT,
                       goal VARCHAR(100),
                       PRIMARY KEY (id)
);
CREATE TABLE Trial (
                       id INT NOT NULL AUTO_INCREMENT,
                       sequence_number INT NOT NULL,
                       goal VARCHAR(100),
                       PRIMARY KEY (id)
);