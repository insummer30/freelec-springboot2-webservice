package me.tom.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    // 스프링 시큐리티에서는 권한 코드에 "ROLE_"이 앞에 있어야 한다고 함.
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반사용자");

    private final String key;
    private final String title;
}
