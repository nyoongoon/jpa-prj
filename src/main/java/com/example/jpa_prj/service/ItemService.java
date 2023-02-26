package com.example.jpa_prj.service;

import com.example.jpa_prj.entity.Item;
import com.example.jpa_prj.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {
    private  ItemRepository itemRepository;

//    public Item findItem(){
//
//        return
//    }

}
