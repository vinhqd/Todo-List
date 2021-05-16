package com.todolist.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponse {

    private String type = "Bearer";
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }
}
