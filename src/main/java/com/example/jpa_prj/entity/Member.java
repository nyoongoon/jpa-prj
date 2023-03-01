package com.example.jpa_prj.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany
    private List<Item> item;

    @ManyToOne
    private Team team;
    //연관관계설정
    public void setTeam(Team team){
        this.team = team;
    }

    public Member() {}

    public Member(String name) {
        this.name = name;
    }

}
