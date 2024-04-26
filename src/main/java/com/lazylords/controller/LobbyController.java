package com.lazylords.controller;

import com.lazylords.service.LobbyService;
import com.lazylords.to.request.LoginRequestTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class LobbyController {
    private final LobbyService lobbyService;

    @PostMapping("/join")
    public ResponseEntity<UUID> join(@RequestBody LoginRequestTO loginForm) {
        return ResponseEntity.ok(lobbyService.join(loginForm.getUsername(), loginForm.getLobbyId()));
    }
}