package me.tom.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DB 접근 레이어 (흔히 DAO라고 불리는거)
 *  - JpaRepository를 상속 받으면 기본적인 CRUD 메소드가 자동 생성 됨!!
 *
 * [주의점]
 *  - Entity와 Entity Repository는 같은 폴더에 존재해야 한다.
 */
public interface PostRepository extends JpaRepository<Posts, Long> {

}