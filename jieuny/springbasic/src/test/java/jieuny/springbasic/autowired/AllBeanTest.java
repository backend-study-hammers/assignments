package jieuny.springbasic.autowired;

import jieuny.springbasic.AutoAppConfig;
import jieuny.springbasic.discount.DiscountPolicy;
import jieuny.springbasic.member.Grade;
import jieuny.springbasic.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {

    @Test
    void test(){
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class);
        DiscountService discountService= ac.getBean(DiscountService.class);
        Member member= new Member("JIEUN", Grade.VIP,1L);
        int discountprice= discountService.discountt(member, 10000, "fixDiscountPolicy");
        assertThat(discountprice).isEqualTo(1000);
    }
    static class DiscountService{
        private Map<String,DiscountPolicy> discountPolicyMap;
        private List<DiscountPolicy> discountPolicies;

        public DiscountService(Map<String,DiscountPolicy> discountPolicyMap, List<DiscountPolicy> discountPolicies){
            this.discountPolicyMap=discountPolicyMap;
            this.discountPolicies=discountPolicies;
            System.out.println("discountPolicyMap = " + discountPolicyMap);
            System.out.println("discountPolicies = " + discountPolicies);
        }

        public int discountt(Member member, int price, String discountCode){
            DiscountPolicy discountPolicy= discountPolicyMap.get(discountCode);

            System.out.println("discountcode = " + discountCode);
            System.out.println("discountPolicy = " + discountPolicy);
            return discountPolicy.discount(member,price);
        }
    }
}
