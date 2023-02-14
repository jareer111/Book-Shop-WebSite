package com.jareer.bookshopwebsite.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class UserDetailsDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private Boolean isActive;
    @Builder.Default
    private List<String> roleList=List.of("USER");
}
