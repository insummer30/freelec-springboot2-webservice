package me.tom.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import me.tom.springboot.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  // spring security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOauth2UserService customOauth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()   // h2-console 화면을 사용하기 위해 disable 시켜줄 것들...
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()    // URL별 권한 관리 설정하는 옵션 시작점 (antMatchers 옵션 사용 가능)
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**")
                    .permitAll()    // 전체 열람 권한 부여
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()   // 이외 모든 것은 인증된 사용자(로그인한 사용자)에게만 허용
                .and()
                    .logout()
                        .logoutSuccessUrl("/")  // 로그아웃 성공시 /로 이동
                .and()
                    .oauth2Login()  // 로그인 기능에 대한 여러 설정의 진입점
                        .userInfoEndpoint() // 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당 (?)
                            .userService(customOauth2UserService);  // 리소스 서버에서 사용자 정보 가져온 다음에 추가로 진행하고자 하는 기능을 지원
    }
}
