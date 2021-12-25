package study.taxi.service.userService;

import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.taxi.api.argument.CreateUserArgument;
import study.taxi.api.exception.UserHasEmptyFieldsException;
import study.taxi.data.entity.Authority;
import study.taxi.data.entity.User;
import study.taxi.data.repository.UserRepository;
import study.taxi.service.authorityService.AuthorityService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthorityService authorityService;

    @Override
    @Transactional
    public User create(CreateUserArgument user) {
        checkUserForExceptions(user);

        Authority authority = authorityService.create(Authority.builder().authority("user").build());

        return userRepository.save(User.builder()
                                       .lastname(user.getLastname())
                                       .firstname(user.getFirstname())
                                       .username(user.getUsername())
                                       .email(user.getEmail())
                                       .password(new BCryptPasswordEncoder().encode(user.getPassword()))
                                       .number(user.getNumber())
                        .authorities(Sets.newHashSet(authority))
                                       .build());
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

    void checkUserForExceptions(CreateUserArgument user){
        if (user.getLastname() == null || user.getLastname().isEmpty() ||
            user.getFirstname() == null || user.getFirstname().isEmpty() ||
            user.getNumber() == null || user.getNumber().isEmpty() ||
            user.getEmail() == null || user.getEmail().isEmpty() ||
            user.getUsername() == null || user.getUsername().isEmpty() ||
            user.getPassword() == null || user.getPassword().isEmpty())
            throw new UserHasEmptyFieldsException("Есть незаполненные данные");
    }
}
