package com.lazylords.domain;


import com.lazylords.enumeration.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 8241072382934708006L;

    private String name;
    private Integer coins = 3;
    private Integer avatarId;
    private PlayerType type;
    private HashMap<Integer, Integer> cards = new HashMap<>();
    private HashMap<Integer, Boolean> establishments = new HashMap<>();
}
