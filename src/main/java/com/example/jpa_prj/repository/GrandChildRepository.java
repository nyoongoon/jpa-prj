package com.example.jpa_prj.repository;

import com.example.jpa_prj.entity.GrandChild;
import com.example.jpa_prj.entity.GrandChildId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrandChildRepository extends JpaRepository<GrandChild, GrandChildId> {
}
