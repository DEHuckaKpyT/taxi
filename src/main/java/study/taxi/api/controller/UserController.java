package study.taxi.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import study.taxi.api.dto.CreateUserDto;
import study.taxi.api.mapper.UserMapper;
import study.taxi.data.entity.User;
import study.taxi.service.userService.UserService;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("create")
    public User create(@RequestBody CreateUserDto createUserDto, Authentication authentication) {
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return userService.create(UserMapper.INSTANCE.toCreateUserArgument(createUserDto));
    }

    @GetMapping("get")
    User get(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userService.getUserByUsername(userDetails.getUsername());
    }
}
