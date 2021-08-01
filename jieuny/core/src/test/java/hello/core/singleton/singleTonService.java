package hello.core.singleton;

public class singleTonService {

    private static singleTonService instance= new singleTonService();

    public static singleTonService getInstance(){
        return instance;
    }
    private singleTonService(){
    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
