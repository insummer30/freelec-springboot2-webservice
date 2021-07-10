package me.tom.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest // 별다른 설정 없이 이걸 쓰게 되면 H2데이터베이스를 자동으로 실행해 줌.
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    // 단위 테스트가 끝날 때마다 호출되는 메소드
    @After
    public void cleanUp() {
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // save는 upsert랑 같음. ID에 해당하는 값이 있으면 update이고 없으면 insert로 수행됨.
        postRepository.save(
                Posts.builder()
                        .title(title)
                        .content(content)
                        .author("taebo")
                        .build()
        );

        // when
        List<Posts> postsList = postRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isNotNull().isEqualTo(title);
        assertThat(posts.getContent()).isNotNull().isEqualTo(content);
        assertThat(posts.getAuthor()).isNotNull().isEqualTo("taebo");
    }
}