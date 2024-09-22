package com.example.account.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration // 자동으로 빈으로 등록되는 타입
@EnableJpaAuditing // 어플리케이션이 실행될 때 해당 클래스가 자동으로 스캔되는 타입
public class JpaAuditingConfiguration {
    // DB에 저장하거나 업데이트할 때 @CreatedDate와 @LastModifiedBy의 값을 자동으로 저장
}
