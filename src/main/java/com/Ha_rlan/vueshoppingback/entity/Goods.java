package com.Ha_rlan.vueshoppingback.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Goods {
    private String name;
    private int price;
    private int remain;
}
