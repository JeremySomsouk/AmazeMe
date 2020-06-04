package com.manomano.AmazeMe.mapper;

import com.manomano.AmazeMe.controller.dto.UserDto;
import com.manomano.AmazeMe.repository.model.User;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper implements Mapper<UserDto, User> {

    public final UserDto toDto(User user) {

        return UserDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .job(user.getJob())
                .advice(user.getAdvice())
                .build();
    }

    public final User toModel(UserDto userDto) {

        return User.builder()
                .userId(userDto.getUserId())
                .username(userDto.getUsername())
                .job(userDto.getJob())
                .action(userDto.getAction())
                .build();
    }
}
