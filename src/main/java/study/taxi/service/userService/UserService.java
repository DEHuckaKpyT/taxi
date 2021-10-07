package study.taxi.service.userService;

import study.taxi.data.entity.User;

public interface UserService {

    User create(User user);

    User getUserByFirstnameLastname(String firstnameLastname);

    User getUserByUsername(String username);
}
