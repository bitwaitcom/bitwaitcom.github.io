package com.bitwait.bitrade.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Poke {
    public Poke(){

    }
    @Id
    private String id;
    public Poke(String price){
        this.price = price;
    }
    private String price;

}
