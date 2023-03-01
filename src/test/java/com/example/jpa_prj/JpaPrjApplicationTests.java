package com.example.jpa_prj;

import com.example.jpa_prj.entity.Member;
import com.example.jpa_prj.entity.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
class JpaPrjApplicationTests {

    @PersistenceContext
    EntityManager em;

    @Test
    void contextLoads() {
    }


    @Test
    @Rollback(false)
    void test(){
        Team team1 = new Team("팀1");
        Member member1 = new Member("회원1");
        member1.setTeam(team1);
        Member member2 = new Member("회원2");
        member2.setTeam(team1);
        System.out.println(team1.getMembers().size());
        assertThat(team1.getMembers().size()).isEqualTo(0);
    }

    @Test
    @Transactional
    @Rollback()
    void test2(){
        Team team1 = new Team("팀1");
        em.persist(team1); //영속성 컨텍스트에 저장
        Member member1 = new Member("회원1");
        member1.setTeam(team1);
        em.persist(member1); //영속성 컨텍스트에 저장
        Member member2 = new Member("회원2");
        member2.setTeam(team1);
        em.persist(member2); //영속성 컨텍스트에 저장

        assertThat(team1.getMembers().size()).isEqualTo(0); // 순수 객체에서는 연관관계 못찾음
        em.flush();
        em.clear();

        //영속성 컨텍스트 플러시 일어난 후, 연관관계 찾을 수 있음!
        //assertThat(em.find(Team.class, team1.getId()).getMembers().size()).isEqualTo(0);

        Team findTeam = em.find(Team.class, team1.getId());

        assertThat(findTeam.getMembers().size()).isEqualTo(2);
    }
}
