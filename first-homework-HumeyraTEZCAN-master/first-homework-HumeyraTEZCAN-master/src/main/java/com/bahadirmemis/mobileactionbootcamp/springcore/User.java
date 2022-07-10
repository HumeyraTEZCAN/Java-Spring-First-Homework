package com.bahadirmemis.mobileactionbootcamp.springcore;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "USER_TABLE")
public class User {


    @Id
    @SequenceGenerator(name ="Users", sequenceName = "USER_ID_SEQ")
    @GeneratedValue(generator = "USERS")
    @Column(name = "User_Id")
    private Long id;
    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 50, nullable = false)
    private String surname;

    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;

    @Column(name = "PHONE", length = 50, nullable = false)
    private String phone;

    private Boolean isActive;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

}
