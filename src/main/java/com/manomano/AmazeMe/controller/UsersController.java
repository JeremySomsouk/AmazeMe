package com.manomano.AmazeMe.controller;

import com.manomano.AmazeMe.controller.dto.UserAnswerDto;
import com.manomano.AmazeMe.controller.dto.UserDto;
import com.manomano.AmazeMe.controller.dto.UserRequestDto;
import com.manomano.AmazeMe.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    UserDto saveUser(@RequestBody UserDto newUser) {
        return usersService.saveUser(newUser);
    }

    @PostMapping("/{userId}/interact")
    UserAnswerDto interactWithUser(@PathVariable(value = "userId") Long userId, @RequestBody UserRequestDto request) {
        checkArgument(userId != null, "UserId must be provided.");
        checkArgument(request != null && request.getAction() != null, "A valid action must be provided.");
        return usersService.interactWithUser(userId, request);
    }

    @GetMapping
    List<UserDto> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{userId}")
    UserDto getUserById(@PathVariable(value = "userId") Long userId) {
        return usersService.findUserById(userId);
    }

    @PutMapping("/{userId}")
    UserDto replaceEmployee(@RequestBody UserDto newUser, @PathVariable(value = "userId") Long userId) {
        return usersService.replaceUserById(userId, newUser);
    }

    @DeleteMapping("/{userId}")
    void deleteEmployee(@PathVariable(value = "userId") Long userId) {
        usersService.deleteUserById(userId);
    }
}