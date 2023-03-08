package com.example.jpa_prj.repository;

import com.example.jpa_prj.entity.Child;
import com.example.jpa_prj.entity.ChildId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, ChildId> {
}
