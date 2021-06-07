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

-- Trial table population
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

-- Quest table population
INSERT INTO Quest (goal) VALUES ("Complete a 5K race");
INSERT INTO Quest (goal) VALUES ("Complete a 10K race");
INSERT INTO Quest (goal) VALUES ("Complete a half marathon race");
INSERT INTO Quest (goal) VALUES ("Complete a marathon race");

-- QuestTrialRelation table population
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (1, 1);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (1, 2);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (1, 3);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (1, 4);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (1, 5);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (1, 6);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (1, 7);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (1, 8);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (1, 9);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (2, 5);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (2, 6);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (2, 8);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (2, 10);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (2, 11);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (2, 12);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (2, 13);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (2, 14);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (2, 15);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (3, 4);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (3, 8);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (3, 9);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (3, 10);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (3, 11);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (3, 12);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (3, 13);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (3, 16);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (3, 17);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (3, 18);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (3, 19);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (3, 20);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (3, 22);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (4, 8);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (4, 12);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (4, 16);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (4, 17);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (4, 18);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (4, 19);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (4, 20);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (4, 21);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (4, 22);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (4, 23);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (4, 24);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (4, 25);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (4, 26);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (4, 27);
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (4, 28);