package me.tom.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

// JUnit으로 스프링부트를 띄워서 테스트할 수 있게 해줌. (JUnit4)
@RunWith(SpringRunner.class)
// spring MVC를 테스트 하기 위함.
// 웹상에서 테스트하기 힘든 컨트롤러를 테스트할 수 있음. @Controller, @ControllerAdvice 지원
@WebMvcTest
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;    // 모든 의존성을 로드하지 않고 Controller 관련 빈만 로드함.
                            // 웹서버에 배포하지 않고도 API 테스트를 할 수 있게 해줌.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))              // GET 요청을 보낼 수 있다.
                .andExpect(status().isOk())               // HTTP status를 검증한다.
                .andExpect(content().string(hello));      // 내용물을 검증한다.

    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}