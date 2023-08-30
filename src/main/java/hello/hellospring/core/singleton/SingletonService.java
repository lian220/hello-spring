package hello.hellospring.core.singleton;

public class SingletonService {

    //1. static 영역 객체는 딱 1개만 만든다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }


    public static void main(String[] args) {
        SingletonService singletonService1 = new SingletonService();
    }
}
