package com.example.account.domain;

import com.example.account.exception.AccountException;
import com.example.account.type.AccountStatus;
import com.example.account.type.ErrorCode;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Account extends BaseEntity { // 테이블
    @ManyToOne
    private AccountUser accountUser;
    private String accountNumber;

    // Enum 값의 숫자가 아닌, 실제 이름(문자열)을 저장하도록 하는 어노테이션
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    private Long balance;

    @CreatedDate
    private LocalDateTime registeredAt;
    @LastModifiedBy
    private LocalDateTime unRegisteredAt;

    // 중요한 데이터를 변경하는 로직은 객체 안에서 직접 수행하도록 구현
    public void useBalance(Long amount) {
        if (amount > balance) {
            throw new AccountException(ErrorCode.AMOUNT_EXCEED_BALANCE);
        }
        balance -= amount;
    }

    public void cancelBalance(Long amount) {
        if (amount < 0) {
            throw new AccountException(ErrorCode.INVALID_REQUEST);
        }
        balance += amount;
    }
}
