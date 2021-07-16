package me.tom.springboot.web;

import lombok.RequiredArgsConstructor;
import me.tom.springboot.service.posts.PostsService;
import me.tom.springboot.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {  // Model은 서버 템플릿엔진에서 사용할 수 있는 객체를 저장할 수 있음.
        // 조회 결과 리스트를 모델에 매핑
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    // 게시글 등록 페이지로 이동
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    // 게시글 수정 페이지로 이동
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable("id") Long id, Model model) {
        PostsResponseDto dto = postsService.findPostsById(id);
        model.addAttribute("posts", dto);
        return "posts-update";
    }
}
