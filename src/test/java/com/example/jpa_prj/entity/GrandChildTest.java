package com.example.jpa_prj.entity;

import com.example.jpa_prj.repository.ChildRepository;
import com.example.jpa_prj.repository.GrandChildRepository;
import com.example.jpa_prj.repository.ParentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GrandChildTest {
    @Autowired
    GrandChildRepository grandChildRepository;
    @Autowired
    ParentRepository parentRepository;
    @Autowired
    ChildRepository childRepository;
    @Test
    @Rollback(value = false)
    void ParentTest(){
        //given
        Parent parent = new Parent();
        parent.setId("parent");
        parentRepository.save(parent);
        //when
        //then
    }

    @Test
    @Rollback(value = false)
    public void ChildTest(){
        Parent parent = parentRepository.findById("parent").orElseThrow();
        Child child = new Child(parent, "child1");
        childRepository.save(child);
    }

    @Test
    @Rollback(value = false)
    public void ChildTest_1(){
        Parent parent = new Parent("parent");
//        Parent parent = parentRepository.findById("parent").orElseThrow();
        Child child = new Child(parent, "child2");
        childRepository.save(child);
    } // 됨 !!!!

    @Test
    @Rollback(value = false)
    public void GrandChildTest1(){
        ChildId childId = new ChildId("parent", "child1"); //new라서 해시코드 동일성 판단 에러..?
        Child child = childRepository.findById(childId).orElseThrow();

        GrandChild grandChild = new GrandChild(child, "grand1");
        grandChildRepository.save(grandChild);
        //Invalid property 'parent' of bean class [com.example.jpa_prj.entity.ChildId]: Bean property 'parent' is not writable or has an invalid setter method. Does the parameter type of the setter match the return type of the getter?
    }

    @Test
    @Rollback(value = false)
    public void GrandChildTest2(){
        Parent parent = new Parent();
        parent.setId("parent");
//        ChildId childId = new ChildId("parent", "child1"); //new라서 해시코드 동일성 판단 에러..?
        Child child = new Child(parent, "child1");

        GrandChild grandChild = new GrandChild(child, "grand1");
        grandChildRepository.save(grandChild);
//       //Invalid property 'parent' of bean class [com.example.jpa_prj.entity.ChildId]: Bean property 'parent' is not writable or has an invalid setter method. Does the parameter type of the setter match the return type of the getter?
    }

    @Test
    @Rollback(value = false)
    public void GrandChildTest1_2(){ // Parent SEtter
        Parent parent = new Parent();
        parent.setId("parent");
        Child child = new Child(parent, "child1");

        GrandChild grandChild = new GrandChild(child, "grand1");
        grandChildRepository.save(grandChild);
    } // 성공 !!!! -> 식별자 클래스들에 @Data 추가했더니 됐음 !!!

}