package com.example.jpa_prj.entity;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GrandChildId implements Serializable {
    private ChildId child; // GrandChild.child 매핑
    private String grandChildId; // GrandChild.grandChildId 매핑
}
