package com.example.account.service;

import com.example.account.aop.AccountLockIdInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class LockAopAspect {
    private final LockService lockService;

    @Around("@annotation(com.example.account.aop.AccountLock) && args(request)")
    public Object aroundMethod(
            ProceedingJoinPoint joinPoint, AccountLockIdInterface request
    ) throws Throwable {
        // Lock 획득 시도
        lockService.lock(request.getAccountNumber());
        try {
            return joinPoint.proceed();
        } finally {
            // Lock 해제
            lockService.unlock(request.getAccountNumber());
        }
    }
}
