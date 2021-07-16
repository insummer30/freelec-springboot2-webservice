package me.tom.springboot.web;

import lombok.RequiredArgsConstructor;
import me.tom.springboot.service.posts.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
