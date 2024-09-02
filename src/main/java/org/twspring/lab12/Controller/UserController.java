package org.twspring.lab12.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.twspring.lab12.Model.User;
import org.twspring.lab12.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //Register is within the AuthController

    @GetMapping("/get-all")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PutMapping("/update-my-info")
    public ResponseEntity update(@AuthenticationPrincipal User userAuthInfo, @RequestBody@Valid User user) {
        userService.updateUser(userAuthInfo.getId(),user);
        return ResponseEntity.status(200).body("User updated successfully");
    }

    @DeleteMapping("/delete-by-the-user")
    public ResponseEntity deleteByTheUser(@AuthenticationPrincipal User userAuthInfo) {
        userService.deleteUserByTheUser(userAuthInfo);
        return ResponseEntity.status(200).body("User deleted successfully");
    }


    @DeleteMapping("/delete-by-admin/{userId}")
    public ResponseEntity deleteByAdmin(@PathVariable Integer userId) {
        userService.deleteUserByAdmin(userId);
        return ResponseEntity.status(200).body("User deleted successfully");
    }


}
