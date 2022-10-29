package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        MemberService memberService1 = appConfig.memberService();

        System.out.println(memberService);
        System.out.println(memberService1);

        assertNotEquals(memberService, memberService1);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        System.out.println(instance1);
        System.out.println(instance2);

        assertEquals(instance1, instance2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService",MemberService.class);
        MemberService memberService1 = ac.getBean("memberService",MemberService.class);

        System.out.println(memberService);
        System.out.println(memberService1);

        assertEquals(memberService, memberService1);
    }
}
