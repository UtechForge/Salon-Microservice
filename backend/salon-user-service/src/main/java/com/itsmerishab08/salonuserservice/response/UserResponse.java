package com.itsmerishab08.salonuserservice.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itsmerishab08.salonuserservice.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends BaseResponse {
    @JsonProperty("user_model")
    private UserModel userModel;
    @JsonProperty("user_list")
    private List<UserModel> users;
}
