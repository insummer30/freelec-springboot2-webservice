package me.tom.springboot.service.posts;

import lombok.RequiredArgsConstructor;
import me.tom.springboot.domain.posts.PostsRepository;
import me.tom.springboot.web.dto.PostsSaveRequestDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
