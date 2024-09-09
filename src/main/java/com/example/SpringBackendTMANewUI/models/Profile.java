package com.example.SpringBackendTMANewUI.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Getter
@Entity
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Profile implements Serializable {
    @Id
    private Long id;

    private String email;

    private String password;

    private String phoneNumber;

    private String name;

    private String address;

    private String gender;

    private boolean isAccess;
}
