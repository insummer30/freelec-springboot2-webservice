package me.tom.springboot.service.posts;

import lombok.RequiredArgsConstructor;
import me.tom.springboot.domain.posts.Posts;
import me.tom.springboot.domain.posts.PostsRepository;
import me.tom.springboot.web.dto.PostsListResponseDto;
import me.tom.springboot.web.dto.PostsResponseDto;
import me.tom.springboot.web.dto.PostsSaveRequestDto;
import me.tom.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        // id에 일치하는 posts를 찾음.
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        // posts 값 업데이트
        // DB에 쿼리를 날리는 부분이 아니라 단순히 setter 역할이지만 트랜잭션이 끝나면 반영을 한다. (JPA의 영속성 컨텍스트)
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return posts.getId();
    }

    public PostsResponseDto findPostsById(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(posts);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
