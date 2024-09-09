package com.example.SpringBackendTMANewUI.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class LoginDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime date_login;
    private Long email_count;

    public LoginDTO(LocalDateTime date_login,Long email_count) {
        this.email_count = email_count;
        this.date_login = date_login;
    }
}
