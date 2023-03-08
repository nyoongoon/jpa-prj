package com.example.jpa_prj.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@IdClass(ChildId.class)
@AllArgsConstructor
//@Setter//추가
public class Child {
    @Id
    @ManyToOne
    @JoinColumn(name = "PARENT_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Parent parent;

    @Id
    @Column(name = "CHILD_ID")
    private String childId;

    public Child() {

    }
}
