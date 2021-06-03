CREATE SCHEMA runningquest;
CREATE TABLE runningquest.User (
                      id INT NOT NULL AUTO_INCREMENT,
                      username VARCHAR(100),
                      password VARCHAR(100),
                      email VARCHAR(100),
                      avatar_id VARCHAR(100),
                      PRIMARY KEY ( id )
);