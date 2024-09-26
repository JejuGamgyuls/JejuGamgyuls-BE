package com.gamgyuls.gamgyuls.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    private String email;
    private String userId;
    private String pwd;
//    private String pwdCheck;
    private String name;
}
