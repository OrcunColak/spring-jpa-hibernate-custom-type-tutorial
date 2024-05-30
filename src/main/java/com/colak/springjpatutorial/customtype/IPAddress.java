package com.colak.springjpatutorial.customtype;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class IPAddress {
    private String address;
}
