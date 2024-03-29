package hello.core.lifecycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient  {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출 url = " + url);
    }


    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connent(){
        System.out.println("connect:" + url);

    }
    public void call(String message){
        System.out.println("call : = " + url + "    message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close:  " + url);
    }

    // 의존관계 주입이 끝나면 호출해주겠다

    @PostConstruct
    public void init() throws Exception {
        System.out.println("init");
        connent();
        call("초기화 연결 메시지");
    }

@PreDestroy
    public void close() throws Exception {
        System.out.println("close");
        disconnect();
    }
}
