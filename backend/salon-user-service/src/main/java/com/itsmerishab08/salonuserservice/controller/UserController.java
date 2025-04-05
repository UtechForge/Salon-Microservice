package com.itsmerishab08.salonuserservice.controller;

import com.itsmerishab08.salonuserservice.request.UserRequest;
import com.itsmerishab08.salonuserservice.response.BaseResponse;
import com.itsmerishab08.salonuserservice.response.UserResponse;
import com.itsmerishab08.salonuserservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create_update")
    public BaseResponse createUpdate(@RequestBody UserRequest userRequest) {
        return userService.createUpdateUser(userRequest);
    }

    @GetMapping("/get_user_by_id")
    public UserResponse getUserById(@RequestParam("id") String id) {
        UserRequest userRequest = new UserRequest();
        userRequest.setId(id);
        return userService.getUserById(userRequest);
    }

    @GetMapping("/get_user_listing")
    public UserResponse getUserListing(
            @RequestParam("page_no") int pageNo,
            @RequestParam("page_size") int pageSize
    ) {
        UserRequest userRequest = new UserRequest();
        userRequest.setPageNumber(pageNo);
        userRequest.setPageSize(pageSize);
        return userService.getUserList(userRequest);
    }

    @PostMapping("/delete_user")
    public BaseResponse deleteUser( @RequestParam("id") String id) {
        UserRequest userRequest = new UserRequest();
        userRequest.setId(id);
        return userService.deleteUser(userRequest);
    }


}
