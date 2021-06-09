CREATE SCHEMA runningquest;
USE runningquest;

-- Clean up before initialization
SET foreign_key_checks = 0;
DELETE FROM QuestTrialRelation;
DELETE FROM UserQuestRelation;
DELETE FROM TrialBossRelation;
DROP TABLE User;
DROP TABLE Quest;
DROP TABLE Trial;
DROP TABLE Boss;
DROP TABLE QuestTrialRelation;
DROP TABLE UserQuestRelation;
DROP TABLE TrialBossRelation;
SET foreign_key_checks = 1;

-- Create tables
CREATE TABLE User (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(100),
    password VARCHAR(100),
    email VARCHAR(100),
    avatar_id VARCHAR(100),
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
CREATE TABLE Boss (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (id)
);
CREATE TABLE QuestTrialRelation (
    quest_id INT NOT NULL,
    trial_id INT NOT NULL,
    FOREIGN KEY (quest_id) REFERENCES Quest(id),
    FOREIGN KEY (trial_id) REFERENCES Trial(id),
    UNIQUE (quest_id, trial_id)
);
CREATE TABLE UserQuestRelation (
    user_id INT NOT NULL,
    quest_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (quest_id) REFERENCES Quest(id),
    UNIQUE (user_id, quest_id)
);
CREATE TABLE TrialBossRelation (
    trial_id INT NOT NULL,
    boss_id INT NOT NULL,
    FOREIGN KEY (trial_id) REFERENCES Trial(id),
    FOREIGN KEY (boss_id) REFERENCES Boss(id),
    UNIQUE (trial_id, boss_id)
);

-- User table population (dummy data)
INSERT INTO User (username, password, email, avatar_id) VALUES ("dummy", "realdumb", "dummy@runningquest.io", "1234");

-- Boss table population
INSERT INTO Boss (name) VALUES ("Giant Rat");
INSERT INTO Boss (name) VALUES ("Slime");
INSERT INTO Boss (name) VALUES ("Bat Swarm");
INSERT INTO Boss (name) VALUES ("Zombie");
INSERT INTO Boss (name) VALUES ("Skeleton");
INSERT INTO Boss (name) VALUES ("Scorpion");
INSERT INTO Boss (name) VALUES ("Wolf Pack");
INSERT INTO Boss (name) VALUES ("Ghost");
INSERT INTO Boss (name) VALUES ("Bandit");
INSERT INTO Boss (name) VALUES ("Goblin");
INSERT INTO Boss (name) VALUES ("Evil Fairy");
INSERT INTO Boss (name) VALUES ("Imp");
INSERT INTO Boss (name) VALUES ("Mummy");
INSERT INTO Boss (name) VALUES ("Werewolf");
INSERT INTO Boss (name) VALUES ("Vampire");
INSERT INTO Boss (name) VALUES ("Minotaur");
INSERT INTO Boss (name) VALUES ("Necromancer");
INSERT INTO Boss (name) VALUES ("Troll");
INSERT INTO Boss (name) VALUES ("Yeti");
INSERT INTO Boss (name) VALUES ("Stone Golumn");
INSERT INTO Boss (name) VALUES ("Ogre");
INSERT INTO Boss (name) VALUES ("Dark Wizard");
INSERT INTO Boss (name) VALUES ("Demon");
INSERT INTO Boss (name) VALUES ("Reaper");
INSERT INTO Boss (name) VALUES ("Green Dragon");
INSERT INTO Boss (name) VALUES ("Blue Dragon");
INSERT INTO Boss (name) VALUES ("Red Dragon");
INSERT INTO Boss (name) VALUES ("Black Dragon");
INSERT INTO Boss (name) VALUES ("Gold Dragon");


-- Trial table population (28)
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
INSERT INTO Trial (goal) VALUES ("Run/walk a 5k, 10k, half marathon, and full marathon");

-- Quest table population
INSERT INTO Quest (goal) VALUES ("Complete a 5K race");
INSERT INTO Quest (goal) VALUES ("Complete a 10K race");
INSERT INTO Quest (goal) VALUES ("Complete a half marathon race");
INSERT INTO Quest (goal) VALUES ("Complete a marathon race");
INSERT INTO QUEST (goal) VALUES ("Complete all races");

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
INSERT INTO QuestTrialRelation (quest_id, trial_id) VALUES (5, 29);

--TrialBossRelation table population
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (1, 1);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (2, 2);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (3, 3);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (4, 4);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (5, 5);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (5, 5);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (6, 6);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (7, 7);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (8, 8);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (9, 25);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (10, 9);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (11, 10);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (12, 11);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (13, 12);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (14, 13);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (15, 26);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (16, 14);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (17, 15);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (18, 16);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (19, 17);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (20, 18);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (21, 19);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (22, 27);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (23, 20);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (24, 21);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (25, 22);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (26, 23);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (27, 24);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (28, 28);
INSERT INTO TrialBossRelation (trial_id, boss_id) VALUES (29, 29);


-- UserQuestRelation table population
INSERT INTO UserQuestRelation (user_id, quest_id) VALUES (1, 1);
INSERT INTO UserQuestRelation (user_id, quest_id) VALUES (1, 2);
