package com.lazylords.repository;

import com.lazylords.domain.Lobby;

import java.util.Optional;

public interface LobbyRepository {
    Optional<Lobby> findById(String id);

    void save(Lobby lobby);
}
