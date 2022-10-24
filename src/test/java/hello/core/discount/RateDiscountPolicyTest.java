package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip10%할인")
    void vip_0() {
        //given
        Member member = new Member(1L, "memberV", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        assertEquals(1000,discount);

    }

    @Test
    @DisplayName("vip아닐때")
    void vip_x() {
        //given
        Member member = new Member(1L, "memberV", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        assertNotEquals(1000,discount);

    }

}