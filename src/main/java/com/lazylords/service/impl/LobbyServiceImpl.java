package com.lazylords.service.impl;

import com.lazylords.domain.Lobby;
import com.lazylords.domain.Player;
import com.lazylords.enumeration.PlayerType;
import com.lazylords.exceptions.LobbyDontExistException;
import com.lazylords.exceptions.LobbyFullExceptionException;
import com.lazylords.exceptions.PlayerAlreadyExistException;
import com.lazylords.repository.LobbyRepository;
import com.lazylords.service.LobbyService;
import com.lazylords.to.response.LobbyResponseTO;
import com.lazylords.util.mapper.PlayerMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class LobbyServiceImpl implements LobbyService {

    private final LobbyRepository lobbyRepository;

    @Override
    @SneakyThrows
    public UUID join(String playerName, UUID lobbyId) {
        log.info("join playerName / lobbyId: {} / {}", playerName, lobbyId);
        Lobby lobby = new Lobby();
        Player player = new Player();
        player.setName(playerName);
        player.setType(lobbyId == null ? PlayerType.HOST : PlayerType.PLAYER);
        if (lobbyId != null) {
            lobby = lobbyRepository.findById(lobbyId.toString()).orElseThrow(LobbyDontExistException::new);
            if (lobby.getPlayers().containsKey(playerName)) {
                throw new PlayerAlreadyExistException();
            } else if (lobby.getPlayers().values().size() == lobby.getSize()) {
                throw new LobbyFullExceptionException();
            }
        } else {
            lobbyId = UUID.randomUUID();
            lobby.setId(lobbyId);
        }
        lobby.getPlayers().put(playerName, player);
        lobbyRepository.save(lobby);
        return lobbyId;
    }

    @Override
    @SneakyThrows
    public LobbyResponseTO leave(UUID lobbyId, String name) {
        Lobby lobby = lobbyRepository.findById(lobbyId.toString()).orElseThrow(LobbyDontExistException::new);
        lobby.getPlayers().remove(name);
        lobbyRepository.save(lobby);
        return new LobbyResponseTO(lobbyId, lobby.getPlayers().values().stream().map(PlayerMapper::toDetails).toList());
    }

    @Override
    @SneakyThrows
    public LobbyResponseTO getLobby(UUID lobbyId) {
        Lobby lobby = lobbyRepository.findById(lobbyId.toString()).orElseThrow(LobbyDontExistException::new);
        return new LobbyResponseTO(lobbyId, lobby.getPlayers().values().stream().map(PlayerMapper::toDetails).toList());
    }
}
