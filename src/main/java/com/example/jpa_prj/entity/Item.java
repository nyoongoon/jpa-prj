package com.example.jpa_prj.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@SequenceGenerator(
        name="ITEM_SEQ_GENERATOR",
        sequenceName = "ITEM_SEQ",
        initialValue = 1, allocationSize = 1
)
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,
                        generator = "ITEM_SEQ_GENERATOR")
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
