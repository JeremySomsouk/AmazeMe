package com.manomano.AmazeMe.service;

import com.manomano.AmazeMe.controller.dto.ActionEnum;
import com.manomano.AmazeMe.controller.dto.UserAnswerDto;
import com.manomano.AmazeMe.controller.dto.UserDto;
import com.manomano.AmazeMe.controller.dto.UserRequestDto;
import com.manomano.AmazeMe.controller.exception.UserNotFoundException;
import com.manomano.AmazeMe.mapper.UsersMapper;
import com.manomano.AmazeMe.repository.UsersRepository;
import com.manomano.AmazeMe.repository.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.manomano.AmazeMe.service.LocationsService.hint2;
import static java.util.stream.Collectors.toList;

@Service
public class UsersService {

    private UsersRepository usersRepository;
    private UsersMapper usersMapper;
    public static String hint1 = "forest";

    @Autowired
    public UsersService(UsersRepository usersRepository,
                        UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }

    public List<UserDto> getAllUsers() {

        List<User> allUsers = usersRepository.findAll();
        return allUsers.stream()
                .map(user -> usersMapper.toDto(user))
                .collect(toList());
    }

    public UserDto saveUser(UserDto newUser) {

        User user = usersMapper.toModel(newUser);
        User savedUser = usersRepository.save(user);
        return usersMapper.toDto(savedUser);
    }

    public UserDto findUserById(Long userId) {

        User user = getUserByIdOrThrow(userId);
        if ("Gandalf The White".equals(user.getUsername())) {
            user.setAdvice("You shall not pass here, go over the " + hint1 + ". And tell the thief what you found.");
        }
        return usersMapper.toDto(user);
    }

    public UserDto replaceUserById(Long userId, UserDto newUser) {

        User user = usersRepository.save(
                usersRepository.findById(userId)
                        .map(users -> {
                            users.setUsername(newUser.getUsername());
                            users.setJob(newUser.getJob());
                            users.setAction(newUser.getAction());
                            return users;
                        })
                        .orElseGet(() -> {
                            User users = usersMapper.toModel(newUser);
                            users.setUserId(userId);
                            return users;
                        })
        );
        return usersMapper.toDto(user);
    }

    public void deleteUserById(Long userId) {
        usersRepository.deleteById(userId);
    }

    public UserAnswerDto interactWithUser(Long userId, UserRequestDto request) {

        User user = getUserByIdOrThrow(userId);
        return getAnswerFromUser(user, request);
    }

    private User getUserByIdOrThrow(Long userId) {
        return usersRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found : userId=%s", userId)));
    }

    private UserAnswerDto getAnswerFromUser(User user, UserRequestDto request) {
        UserAnswerDto userAnswer = new UserAnswerDto();
        if ("Frodo Baggins".equals(user.getUsername()) &&
                request.getAction().equals(ActionEnum.TALK) &&
                request.getSentence().equals(hint2)
        ) {
            userAnswer.setAnswer("Why didnt you said that earlier ?! I know the way. Follow me to the mountain.");
        } else if (request.getAction().equals(ActionEnum.FIGHT) || (request.getAction().equals(ActionEnum.THREATEN))) {
            userAnswer.setAnswer("Leave me alone, bully !");
        } else {
            userAnswer.setAnswer("Huh ?");
        }

        return userAnswer;
    }
}
