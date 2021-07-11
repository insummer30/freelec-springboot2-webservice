package me.tom.springboot.web;

import lombok.RequiredArgsConstructor;
import me.tom.springboot.service.posts.PostsService;
import me.tom.springboot.web.dto.PostsSaveRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor    // 이런식으로 생성자 주입을 사용할 수 있음.
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

}
