package me.tom.springboot.web.dto;

import lombok.Getter;
import me.tom.springboot.domain.posts.Posts;

/**
 * Entity의 일부 값을 사용해서 빈환용 DTO를 만들어 낸다.
 *  - Web Layer에 절대로 Entity 자체를 넘기지 않도록 하자.
 */
@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        id = entity.getId();
        title = entity.getTitle();
        content = entity.getContent();
        author = entity.getAuthor();
    }
}
