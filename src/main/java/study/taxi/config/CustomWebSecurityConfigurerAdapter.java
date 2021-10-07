package study.taxi.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    private final MyUserDetailsService myUserDetailsService;
    private final MyBasicAuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .cors().and()
//                .authorizeRequests().anyRequest().permitAll().and()
            .authorizeRequests().antMatchers("/js/**", "/css/**", "/images/**", "/ico/**").permitAll().and()
            .authorizeRequests().antMatchers("/login", "/registration").permitAll().and()
            .authorizeRequests().anyRequest().authenticated().and()
            .httpBasic().authenticationEntryPoint(authenticationEntryPoint).and()
            .formLogin().loginPage("/login").failureUrl("/login?error").defaultSuccessUrl("/index", true).and()
            .httpBasic().and()
            .exceptionHandling().and()
            .sessionManagement().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder)
            throws Exception {
        builder.userDetailsService(myUserDetailsService);
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return myUserDetailsService;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:8080")
                .allowedOrigins("*")
                .allowCredentials(false).maxAge(3600)
                .allowedMethods("GET", "POST", "OPTIONS");
    }
}
