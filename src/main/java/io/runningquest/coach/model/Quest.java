package io.runningquest.coach.model;

import javax.persistence.*;

@Entity
@Table(name = "Quest", schema = "runningquest")
public class Quest {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long questID;

    @Column(name = "goal")
    private String questGoal;

    public Long getQuestID() {
        return questID;
    }

    public void setQuestID(Long questID) {
        this.questID = questID;
    }

    public String getQuestGoal() {
        return questGoal;
    }

    public void setQuestGoal(String questGoal) {
        this.questGoal = questGoal;
    }

}
