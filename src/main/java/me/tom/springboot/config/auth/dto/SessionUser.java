package me.tom.springboot.config.auth.dto;

import lombok.Getter;
import me.tom.springboot.domain.user.User;

import java.io.Serializable;

/**
 * 인증된 사용자 정보를 담는거.
 */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
