package com.lazylords.service;

import com.lazylords.to.response.LobbyResponseTO;
import lombok.SneakyThrows;

import java.util.UUID;

public interface LobbyService {
    UUID join(String username, UUID lobbyId);

    @SneakyThrows
    LobbyResponseTO getLobby(UUID lobbyId);
}
