package com.example.jpa_prj.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class Item {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int price;

    @ManyToOne(targetEntity = Member.class)
    private Member member;
    public Item() {}

    public Item(String name) {
        this.name = name;
    }


}
