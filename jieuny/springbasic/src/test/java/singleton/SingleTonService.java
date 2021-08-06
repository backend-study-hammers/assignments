package singleton;

public class SingleTonService {
    private static final SingleTonService singleTonService=new SingleTonService();

    public static SingleTonService getinstance(){
        return singleTonService;
    }
    private SingleTonService(){
    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
