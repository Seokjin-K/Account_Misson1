package com.example.account.exception;

import com.example.account.type.ErrorCode;
import lombok.*;

// Exception을 상속받으면 checked exception이다.
// checked exception은 트랜잭션 롤백 대상이 되지 않는다.
// 이 때문에 잘 사용하지 않는 추세
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountException extends RuntimeException {
    private ErrorCode errorCode;
    private String errorMessage;

    public AccountException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDescription();
    }
}
