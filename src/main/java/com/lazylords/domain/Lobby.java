package com.lazylords.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lobby implements Serializable {
    @Serial
    private static final long serialVersionUID = 7392250421493387063L;

    private UUID id;
    private Integer size = 5;
    private HashMap<String, Player> players = new HashMap<>();
    private HashMap<Integer, Integer> desk = new HashMap<>();
}
