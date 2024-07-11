package com.example.springWeekTwo.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Entity
@Data
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"}),

})
// @UniqueConstraint(columnNames = {"phoneNumber"})
public class Customer implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //giai thich; day la field key de phat sinh 1 du lieu
    //annotations lombok cho phep getter setter contructor
    @Column(columnDefinition = "varchar(30)", nullable=false)
    private String email;
    //@Column(unique = true) cau hinh thông tin field SQL

    @Column(columnDefinition = "varchar(30)", nullable=false)
    private String codeCountry;

    @Column(columnDefinition = "varchar(15)", nullable=false)
    private String phoneNumber;

    @Column(columnDefinition = "varchar(200)", nullable=false)
    private String password;

    @Column(columnDefinition = "varchar(30)", nullable=false)
    private String name;

    @Column(columnDefinition = "varchar(60)", nullable=false)
    private String address;

    @Column(columnDefinition = "varchar(10)", nullable=false)
    private String gender;
    //    Giai thich: vi chung ta se dinh nghia
    //    csdl de jpa phu hop voi kieu
    //    du lieu tuong ung va yeu cau
    //    null hay ko dua
    //    dua tren annotations
    //Vì
    /*
    @Id: Đánh dấu trường/cột là khóa chính (primary key) của bảng.
    @GeneratedValue(strategy = GenerationType.IDENTITY):
    Chỉ định rằng giá trị của khóa chính sẽ được tự động sinh ra bởi cơ sở dữ liệu.
    chung ta tao constructor ko truyen key id;
     */

}
