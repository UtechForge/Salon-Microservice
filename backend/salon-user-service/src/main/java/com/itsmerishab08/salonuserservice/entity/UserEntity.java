package com.itsmerishab08.salonuserservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
public class UserEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String userName;
    private String email;
    private String phoneNumber;
    private String role;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}
