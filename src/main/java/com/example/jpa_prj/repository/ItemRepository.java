package com.example.jpa_prj.repository;

import com.example.jpa_prj.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface ItemRepository
        extends JpaRepository<Item, Long>,CustomItemRepository {
    List<Item> search();
}
