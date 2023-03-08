package com.example.jpa_prj.entity;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChildId implements Serializable {
    private String parent; // Child.parent 매핑
    private String childId; // Child.childId 매핑
}
