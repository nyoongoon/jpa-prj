package com.example.jpa_prj.repository;

import com.example.jpa_prj.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, String> {
}
