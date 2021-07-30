package hello.core.singletone;

public class SingletoneService {

    // static 영역에 객체를 딱 1개만 생성
    private static final SingletoneService instance = new SingletoneService();

    // public으로 열어서 객체 인스턴스가 필요하면 static 메서드를 통해서만 조회하도록 허용
    public static SingletoneService getInstance(){
        return instance;
    }

    // 생성자가 private이므로 new 키워드를 사용한 객체 생성을 막음
    private SingletoneService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
