package com.example.jpa_prj.repository;

import com.example.jpa_prj.entity.Item;

import java.util.List;

public interface CustomItemRepository {
    public List<Item> search();
}
