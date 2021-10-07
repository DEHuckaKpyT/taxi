package study.taxi.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import study.taxi.service.userService.UserService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        study.taxi.data.entity.User user = userService.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("user"));

        return new User(username, user.getPassword(), authorities);
    }
}
