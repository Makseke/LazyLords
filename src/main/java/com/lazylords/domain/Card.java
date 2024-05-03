package com.lazylords.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Card {
    private Integer id;
    private String name;
    private String description;
    private Integer imageId;
    private Integer cost;
}
