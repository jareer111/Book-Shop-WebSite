package com.jareer.bookshopwebsite.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Boolean isActive;
    @Builder.Default
    private List<String> role=List.of("USER");


}
