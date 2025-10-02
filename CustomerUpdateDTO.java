package com.bank.app.dto;

import lombok.Data;

@Data
public class CustomerUpdateDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNo;
}
