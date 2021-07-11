package me.tom.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 응답을 위한 DTO (Data Transfer Object)
 */
@Getter                             // 선언된 모든 필드의 getter를 만들어 줌.
@RequiredArgsConstructor            // 선언된 모든 final 필드가 포함된 생성자를 만들어 줌.
public class HelloResponseDto {
    private final String name;
    private final int amount;
}