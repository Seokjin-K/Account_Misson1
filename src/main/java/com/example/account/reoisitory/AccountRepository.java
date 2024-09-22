package com.example.account.reoisitory;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // 스프링에서 JPA를 손쉽게 사용하도록 만드는 기능
    // <Repository가 활용될 엔티티, 엔티티의 Primary Key Type>

    // 이름만 형식에 맞추면 자동으로 쿼리가 생성된다.
    Optional<Account> findFirstByOrderByIdDesc();

    Integer countByAccountUser(AccountUser accountUser);

    // Account의 accountNumber로 검색하여 결과를 반환
    Optional<Account> findByAccountNumber(String accountNumber);

    // JPA 기능
    // Account에 AccountUser가 포함되어 있기 때문에 해당 메소드가 자동으로 생성된다.
    List<Account> findByAccountUser(AccountUser accountUser);
}
