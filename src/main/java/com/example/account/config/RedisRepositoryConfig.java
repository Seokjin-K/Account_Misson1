package com.example.account.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisRepositoryConfig {
    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisProt;

    @Bean // 관례상 메서드 이름으로 자동 등록
    public RedissonClient redissonClient() {
        // redisson client를 주입 받으면 여기서 한번 생성된 클라이언트가 쓰인다.
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + redisHost + ":" + redisProt);
        return Redisson.create(config);
    }
}
