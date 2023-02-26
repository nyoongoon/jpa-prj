package com.example.jpa_prj;

import com.example.jpa_prj.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Example {
    @Controller
    class HelloController{
        @Autowired HelloService helloService;
        public void hello(){
            // 4 반환된 member 엔티티는 준영속 상태다.
            Member member = helloService.logic();
        }
    }
    @Service
    class HelloService{
        @PersistenceContext // 스프링 컨테이너가 엔티티 매니저 주입
        EntityManager em;
        @Autowired Repository1 repository1;
        @Autowired Repository2 repository2;
        // 1.트랜잭션 시작
        @Transactional // 스프링 트랜잭션 AOP가 메소드 호출할 때 트랜잭션을 먼저 시작.
        public Member logic(){
            repository1.hello();
            // 2.member는 영속상태다.
            Member member = repository2.findMember();
            return member; // 메소드 정상 종료되면 트랜잭션 커밋, 트랜잭션 종료, 영속성 컨텍스트 종료.
        }
        // 3.트랜잭션 종료 ->
    }
    @Repository
    class Repository1{
        @PersistenceContext
        EntityManager em;
        public void hello(){
            em.xxx(); //A. 영속성컨텍스트접근
        }
    }
    @Repository
    class Repository2{
        @PersistenceContext
        EntityManager em;
        public Member findMember(){
            return em.find(Member.class, "id1"); // B 영속성 컨텍스트 접근
        }
    }
}
