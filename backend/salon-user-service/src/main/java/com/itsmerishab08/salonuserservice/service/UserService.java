package com.itsmerishab08.salonuserservice.service;

import com.itsmerishab08.salonuserservice.request.UserRequest;
import com.itsmerishab08.salonuserservice.response.BaseResponse;
import com.itsmerishab08.salonuserservice.response.UserResponse;

public interface UserService {

    BaseResponse createUpdateUser(UserRequest user);
    BaseResponse deleteUser(UserRequest user);
    UserResponse getUserById(UserRequest user);
    UserResponse getUserList(UserRequest user);

}
