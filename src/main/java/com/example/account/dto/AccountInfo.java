package com.example.account.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountInfo {
    // 클라이언트와 컨트롤러 사이에 응답을 주고 받을 때 사용하는 DTO

    private String accountNumber;
    private Long balance;
}
