package com.matheusdev.dscommerce.dto;

import com.matheusdev.dscommerce.entities.User;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private LocalDate birthDate;

    private List<String> roles = new ArrayList<>();

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        phone = user.getPhone();
        birthDate = user.getBirthDate();
        for (GrantedAuthority role : user.getRoles()) {
            roles.add(role.getAuthority());
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<String> getRoles() {
        return roles;
    }
}
