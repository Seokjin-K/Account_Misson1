package com.example.account.reoisitory;


import com.example.account.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {
    // JpaRepository를 상속받고 구현체는 스프링이 자동으로 만들고,
    // 우리는 이것을 가져다 사용하기만 하면 된다.

    // TransactionId 컬럼을 통해 select하는 쿼리가 자동으로 생성
    Optional<Transaction> findByTransactionId(String transactionId);
}
