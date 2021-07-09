package me.tom.springboot.web;

import me.tom.springboot.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// JSON을 반환하는 컨트롤러를 만들어줌. (즉, HTML 페이지를 반환하지 않음)
@RestController
public class HelloController {

    // HTTP GET요청을 받아들일 수 있다.
    @GetMapping("/hello")
    public String hello() throws Exception {
        return "hello";
    }

    // DTO를 사용한 버전
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(
            @RequestParam("name") String name,          // 외부에서 "name"으로 넘긴 파라미터를 String name 변수에 저장
            @RequestParam("amount") int amount
    ) {
        return new HelloResponseDto(name, amount);
    }
}
