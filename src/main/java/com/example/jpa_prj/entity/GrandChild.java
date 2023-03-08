package com.example.jpa_prj.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Entity
@IdClass(GrandChildId.class)
@AllArgsConstructor
public class GrandChild {
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)),
            @JoinColumn(name = "CHILD_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    })
    private Child child;

    @Id
    @Column(name = "GRANDCHILD_ID")
    private String grandChildId;

    public GrandChild() {

    }
}
