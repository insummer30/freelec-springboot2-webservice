package me.tom.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// JPA Auditing 어노테이션을 모두 활성화 하기 위해 추가함.
@EnableJpaAuditing
// 스프링부트의 자동 설정, 스프링 빈 스캔 및 생성을 모두 자동으로 해줌.
// 웬만하면 항상 패키지 최상위에 위치하는게 좋다.
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // run을 통해서 내장 톰캣을 수행시킴
        // 내장 WAS를 쓰는 이유는 '언제 어디서나 같은 환경에서 스프링부트를 배포할 수 있기 때문'
        SpringApplication.run(Application.class, args);
    }
}
