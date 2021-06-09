package io.runningquest.coach.model;

import javax.persistence.*;

@Entity
@Table(name = "Boss", schema = "runningquest")
public class Boss {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long bossID;

    @Column(name = "name")
    private String bossName;

    public Long getBossID() {
        return bossID;
    }

    public void setBossID(Long bossID) {
        this.bossID = bossID;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }
}
