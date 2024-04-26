package com.lazylords.to.domain;

import com.lazylords.enumeration.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDetails {
    private Integer avatarId;
    private String playerName;
    private PlayerType playerType;
}
