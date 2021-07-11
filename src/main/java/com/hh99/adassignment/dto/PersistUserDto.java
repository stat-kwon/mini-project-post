package com.hh99.adassignment.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersistUserDto {

    public PersistUserDto(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    private Long id;
    private String name;
    private String email;
    private String password;
}
