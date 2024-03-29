package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// @Bean  memverService -> new MemoryMemberRepository()
// @Bean orderService ->  new MemoryMemberRepository

//예상
//call AppConfig.memberService
//call AppConfig.memberRepository
//call AppConfig.memberRepository
//call AppConfig.orderService
//call AppConfig.memberRepository


// 실제 실행시 1번만 실행됨
//call AppConfig.memberService
//call AppConfig.memberRepository
//call AppConfig.orderService


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.membeService");
        return new MemberServiceImpl(memberRepository()); //생성자 주입
    }

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");

      return new OrderServiceImpl(memberRepository(), discountPolicy());

    }

    @Bean
    private static DiscountPolicy discountPolicy() {
        //return new Fix~~(); 교체하기 참 편해~
        return new RateDiscountPolicy();
    }
}
