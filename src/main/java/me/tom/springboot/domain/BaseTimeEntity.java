package me.tom.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 모든 Entity 클래스의 상위 클래스가 되어 Entity들의 createdDate, modifiedDate를 자동으로 관리하는 역할
 */
@Getter
@MappedSuperclass   // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우, createdDate, modifiedDate도 컬럼으로 인식하도록 함.
@EntityListeners(AuditingEntityListener.class)  // BaseTimeEntity에 Auditing 기능을 포함 시킴.
public abstract class BaseTimeEntity {

    // Entity가 생성될 때 자동으로 생성 시간을 저장
    @CreatedDate
    private LocalDateTime createdDate;

    // Entity의 값이 수정될 때 자동으로 시간이 저장
    @LastModifiedDate
    private LocalDateTime modifiedDate;

}