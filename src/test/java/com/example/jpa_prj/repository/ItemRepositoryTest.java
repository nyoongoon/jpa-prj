package com.example.jpa_prj.repository;

import com.example.jpa_prj.entity.Item;
import com.example.jpa_prj.entity.QItem;
import com.mysema.commons.lang.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;
    Item item;
    QItem qItem = QItem.item;
    @BeforeEach
    public void createEntity(){
        this.item = new Item("item1");
    }

    @Test
    public void jpaTest(){
        Item savedItem = itemRepository.save(item);
        assertThat(item.getName()).isEqualTo(savedItem.getName());
    }

    @Test
    @Rollback(false)
    public void queryDslTest(){
        Item savedItem = itemRepository.save(item);
    }
}