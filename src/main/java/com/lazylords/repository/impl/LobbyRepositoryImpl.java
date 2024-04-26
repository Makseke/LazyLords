package com.lazylords.repository.impl;

import com.lazylords.domain.Lobby;
import com.lazylords.repository.LobbyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Repository
@RequiredArgsConstructor
public class LobbyRepositoryImpl implements LobbyRepository {
    private final RedisTemplate<String, Lobby> redisTemplate;

    @Override
    public Optional<Lobby> findById(String id) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(id));
    }

    @Override
    public void save(Lobby lobby) {
        redisTemplate.opsForValue().set(lobby.getId().toString(), lobby, 1L, TimeUnit.MINUTES);
    }
}
