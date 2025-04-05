package com.itsmerishab08.salonuserservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserModel {
    @JsonProperty("user_id")
    private String id;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("user_email")
    private String email;
    @JsonProperty("user_phone_number")
    private String phoneNumber;
    @JsonProperty("user_role")
    private String role;
}
