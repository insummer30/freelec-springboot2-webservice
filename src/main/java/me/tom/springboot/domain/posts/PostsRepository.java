package me.tom.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * DB 접근 레이어 (흔히 DAO라고 불리는거)
 *  - JpaRepository를 상속 받으면 기본적인 CRUD 메소드가 자동 생성 됨!!
 *
 * [주의점]
 *  - Entity와 Entity Repository는 같은 폴더에 존재해야 한다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

    // 아이디 순서로 읽어오는거 (Posts는 클래스 이름이랑 대소문자가 일치해야 한다. 음 왜지?)
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}