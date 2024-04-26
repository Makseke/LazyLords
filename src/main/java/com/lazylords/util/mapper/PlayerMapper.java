package com.lazylords.util.mapper;

import com.lazylords.domain.Player;
import com.lazylords.to.domain.PlayerDetails;

public final class PlayerMapper {
    public static PlayerDetails toDetails(Player player) {
        PlayerDetails details = new PlayerDetails();
        details.setPlayerName(player.getName());
        details.setAvatarId(1);
        details.setPlayerType(player.getType());
        return details;
    }
}
