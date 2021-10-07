package study.taxi.service.userService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.taxi.data.entity.User;
import study.taxi.data.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByFirstnameLastname(String firstnameLastname) {
        String[] firstAndLast = firstnameLastname.split(";");
        return userRepository.findByFirstnameAndLastname(firstAndLast[0], firstAndLast[1]);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
