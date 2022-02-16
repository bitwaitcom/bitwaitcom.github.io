package com.bitwait.bitrade.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PresetPrice {
    public PresetPrice(){

    }
    @Id
    private String id;
    public PresetPrice(String price){
        this.price = price;
    }
    private String price;

}
