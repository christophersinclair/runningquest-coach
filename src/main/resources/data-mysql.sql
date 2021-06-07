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
                       goal VARCHAR(100),
                       PRIMARY KEY (id)
);
CREATE TABLE QuestTrialRelation (
                                    quest_id INT NOT NULL,
                                    trial_id INT NOT NULL,
                                    FOREIGN KEY (quest_id) REFERENCES Quest(id),
                                    FOREIGN KEY (trial_id) REFERENCES Trial(id),
                                    UNIQUE (quest_id, trial_id)
);
INSERT INTO Trial (goal) VALUES ("Run/walk 1 mile");
INSERT INTO Trial (goal) VALUES ("Run/walk 1.5 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 1.75 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 2 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 2.25 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 2.5 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 2.75 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 3 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 3.11 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 3.5 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 4 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 4.5 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 5 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 5.5 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 6.22 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 6 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 7 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 8 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 9 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 10 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 12 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 13.1 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 14 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 15 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 16 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 18 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 20 miles");
INSERT INTO Trial (goal) VALUES ("Run/walk 26.2 miles");
