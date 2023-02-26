package com.example.jpa_prj.repository;

import com.example.jpa_prj.entity.Item;
import com.example.jpa_prj.entity.QItem;
import com.example.jpa_prj.entity.QMember;


import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;


import java.util.List;

public class ItemRepositoryImpl extends QuerydslRepositorySupport implements CustomItemRepository{
    public ItemRepositoryImpl(){
        super(Item.class);
    }
    @Override
    public List<Item> search(){
        QItem qItem = QItem.item;
        QMember qMember = QMember.member;
        JPQLQuery query = from(qItem);
        query.leftJoin(qItem.member, qMember)
                .where(qItem.name.contains("item1"));
        return query.fetch();
    }
}
