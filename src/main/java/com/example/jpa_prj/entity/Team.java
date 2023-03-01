package com.example.jpa_prj.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Team {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<Member>();

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }
}
