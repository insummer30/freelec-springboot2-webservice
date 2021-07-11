package me.tom.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.tom.springboot.domain.posts.Posts;

/**
 * 데이터 전달 객체
 *  - 절대로 Entity 클래스를 Request/Response 클래스로 사용하지 않는다.
 *
 *  - DTO (View를 위한 클래스, 언제든지 변할 수 있다.)
 *      - Web Layer <--> Service Layer
 *  - Entiry (테이블과 맞닿은 객체, 변화가 적어야 한다.)
 *      - Service Layer -> Repository Layer
 */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // DTO -> Entity 만들어주는 메소드. 그 반대는 필요 없나?
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
