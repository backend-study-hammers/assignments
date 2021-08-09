package jieuny.springbasic.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {
    private String UUID;
    private String requesturl;

    public void setRequesturl(String url){
        this.requesturl=url;
    }
    public void log(String message){
        System.out.println("["+UUID+"]"+"["+requesturl+"]"+message);
    }
    @PostConstruct
    void init(){
        UUID = java.util.UUID.randomUUID().toString();
        System.out.println("["+UUID+"] request scope bean create"+this);

    }
    @PreDestroy
    void close(){
        System.out.println("["+UUID+"] request scope bean close"+this);

    }
}
