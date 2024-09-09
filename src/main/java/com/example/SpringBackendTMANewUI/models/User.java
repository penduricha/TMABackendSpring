package com.example.SpringBackendTMANewUI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Getter
@Entity
@Data
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /*
        {
        "name": "Leanne Graham",
        "username": "Bret",
        "email": "Sincere@april.biz",
        "phone": "1-700-736-8031 x56442",
        "company": "Romaguera-Crona",
        "website": "hildegard.org"
      },
     */
    @Id
    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String company;
    private String website;
}
