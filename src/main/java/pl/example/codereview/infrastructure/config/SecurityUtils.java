package pl.example.codereview.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.example.codereview.domain.user.UserController;

@Service
public class SecurityUtils {

    private UserController userController;

    public SecurityUtils(UserController userController) {
        this.userController = userController;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public String getCurrentUserLogin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (String) auth.getPrincipal();
    }

    public int getCurrentUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try{
            return userController.getUserByLogin((String) auth.getPrincipal()).getId();
        } catch (NullPointerException ex) {
            throw new Unauthorized();
        }
    }
}
