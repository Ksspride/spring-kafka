package com.kss.kafka.dto;


import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String name;
    private String address;
    private String email;

}
