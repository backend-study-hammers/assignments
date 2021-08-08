package jieuny.springbasic.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;
    public NetworkClient(){
        System.out.println("url이 연결되었습니다");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect(){
        System.out.println("connnect "+url);
    }

    public void call(String message){
        System.out.println(url +"  " +message);
    }
    public void disconnect(){
        System.out.println("disconnect = " + url);
    }

    @PreDestroy
    public void close() {
        disconnect();
    }

    @PostConstruct
    public void init() {
        connect();
        call("초기화 연결 메세지");
    }
}
