package io.runningquest.coach.model;

import javax.persistence.*;

@Entity
@Table(name = "Trial", schema = "runningquest")
public class Trial {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long trialID;

    @Column(name = "goal")
    private String trialGoal;

    public Long getTrialID() {
        return trialID;
    }

    public void setTrialID(Long trialID) {
        this.trialID = trialID;
    }


    public String getTrialGoal() {
        return trialGoal;
    }

    public void setTrialGoal(String trialGoal) {
        this.trialGoal = trialGoal;
    }
}
