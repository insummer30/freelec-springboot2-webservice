package me.tom.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.tom.springboot.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor  // 롬복, 기본생성자 자동추가
@Entity             // JPA 애노테이션, 테이블과 링크될 클래스라는 것을 의미. (기본으로 카멜케이스 클래스 이름을 언더스코어 네이밍의 테이블에 매칭)
public class Posts extends BaseTimeEntity {

    @Id // 테이블의 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙, auto_increment
    private Long id;

    // 문자열의 경우 varchar(255)가 기본값
    @Column(length = 500, nullable = false)
    private String title;

    // Text 타입으로 변경
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // @Column 애노테이션을 쓰지 않더라도 컬림이 됨. 기본값 외에 변경할게 있으면 @Column을 써서 커스텀한다.
    private String author;

    // 해당 클래스의 빌더 패턴 클래스 자동 생성
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
