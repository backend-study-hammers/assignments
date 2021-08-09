package jieuny.springbasic.autowired;

import jieuny.springbasic.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWired {

    @Test
    void autooptional(){
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(scan.class);

    }
    static class scan{
        @Autowired(required = false)
        public void set1(Member member){
            System.out.println("set1="+member);
        }
        @Autowired
        public void set2(@Nullable Member member){
            System.out.println("set2="+member);

        }
        @Autowired
        public void set3(Optional<Member> member){
            System.out.println("set3="+member);

        }
    }
}
