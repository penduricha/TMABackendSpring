package com.example.SpringBackendTMANewUI.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class RegisterDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime date_signup;
    private Long email_count;

    public RegisterDTO(LocalDateTime date_signup,Long email_count) {
        this.email_count = email_count;
        this.date_signup = date_signup;
    }
}
