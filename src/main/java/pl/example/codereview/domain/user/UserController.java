package pl.example.codereview.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        this.userRepository.save(user);
    }

    public User getUserById(int id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFound("No user for given id"));
    }

    public User getUserByLogin(String login) {
        return userRepository.findFirstByLogin(login);
    }
}
