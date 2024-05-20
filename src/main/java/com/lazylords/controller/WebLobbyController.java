package com.lazylords.controller;

import com.lazylords.service.LobbyService;
import com.lazylords.to.response.EmptyResponseTO;
import com.lazylords.to.response.LobbyResponseTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@Slf4j
@Controller
@CrossOrigin
@RequiredArgsConstructor
public class WebLobbyController {
    private final LobbyService lobbyService;

    @MessageMapping("/join/{lobbyId}")
    @SendTo("/topic/lobby/{lobbyId}")
    public ResponseEntity<LobbyResponseTO> handleJoin(@DestinationVariable String lobbyId) {
        log.info("Received join request for lobby {}", lobbyId);
        HttpHeaders headers = new HttpHeaders();
        headers.set("type", "update");
        return ResponseEntity.ok().headers(headers).body(lobbyService.getLobby(UUID.fromString(lobbyId)));
    }

    @MessageMapping("/leave/{lobbyId}")
    @SendTo("/topic/lobby/{lobbyId}")
    public ResponseEntity<LobbyResponseTO> handleLeave(@Payload String name, @DestinationVariable String lobbyId) {
        log.info("Received leave request for lobby {} by {}", lobbyId, name);
        HttpHeaders headers = new HttpHeaders();
        headers.set("type", "leave");
        return ResponseEntity.ok().headers(headers).body(lobbyService.leave(UUID.fromString(lobbyId), name));
    }

    @MessageMapping("/start/{lobbyId}")
    @SendTo("/topic/lobby/{lobbyId}")
    public ResponseEntity<EmptyResponseTO> handleStartGame(@DestinationVariable String lobbyId) {
        log.info("Received start request for lobby {}", lobbyId);
        HttpHeaders headers = new HttpHeaders();
        headers.set("type", "start");
        return ResponseEntity.ok().headers(headers).body(new EmptyResponseTO());
    }
}
