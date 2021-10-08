package study.taxi.service.userService;

import study.taxi.api.argument.CreateUserArgument;
import study.taxi.data.entity.User;

public interface UserService {

    User create(CreateUserArgument user);

    User getUserByFirstnameLastname(String firstnameLastname);

    User getUserByUsername(String username);
}
