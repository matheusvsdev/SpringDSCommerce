package com.matheusdev.dscommerce.dto;

import com.matheusdev.dscommerce.entities.User;

public class UserMinDTO {

    private Long id;

    private String name;

    public UserMinDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserMinDTO(User user) {
        id = user.getId();
        name = user.getUsername();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
