package com.example.SpringBackendTMANewUI.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Entity
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ButtonSearch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime date_click;

    @Column(columnDefinition = "varchar(100)")
    private String key_word;
    public ButtonSearch(String email, LocalDateTime date_click) {
        this.email = email;
        this.date_click = date_click;
    }

}
