package me.tom.springboot.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // test
        // assertj의 assertThat을 사용하면 가독성이 좋고 체이닝을 이용해서 여러가지를 한번에 검증할 수 있다.
        assertThat(dto.getName()).isNotNull().isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}