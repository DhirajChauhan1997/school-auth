package com.dc.school.subject.controller;

import com.dc.school.model.User;
import com.dc.school.subject.utils.JwtUtil;
import com.dc.school.service.UserService;
import com.dc.school.tos.UserTO;
import com.dc.school.utility.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserTO>> authUser(@RequestBody User userRequest) {
        UserTO user = userService.getUserByUsernameAndPassword(
                userRequest.getUsername(), userRequest.getPassword());
        if (user != null) {
            String jwt= jwtUtil.generateToken(user.getUsername());
            user.setJwtToken(jwt);
            return ResponseEntity.ok(ApiResponse.success(user));
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ApiResponse.error("Invalid username or password"));
        }
    }
}
