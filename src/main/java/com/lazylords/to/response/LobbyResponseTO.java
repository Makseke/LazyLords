package com.lazylords.to.response;

import com.lazylords.to.domain.PlayerDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LobbyResponseTO {
    private UUID lobbyId;
    private List<PlayerDetails> players;
}
