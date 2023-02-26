package com.example.jpa_prj.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany
    private List<Item> item;

    public Member() {}

    public Member(String name) {
        this.name = name;
    }

}
