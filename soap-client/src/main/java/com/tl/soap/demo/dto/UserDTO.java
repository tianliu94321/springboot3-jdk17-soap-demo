package com.tl.soap.demo.dto;

import lombok.Data;

/**
 * @author TL
 */
@Data
public class UserDTO {
    private Long id;
    private String name;
    private Integer age;
    private String address;
}