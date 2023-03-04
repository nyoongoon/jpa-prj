package com.example.jpa_prj.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    //    @OneToMany(mappedBy = "team")
    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<Member> members = new ArrayList<Member>();

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }
}
