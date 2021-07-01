package pl.example.codereview.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.example.codereview.api.dto.UserRequestDto;
import pl.example.codereview.api.mapping.DtoMapper;
import pl.example.codereview.domain.user.User;
import pl.example.codereview.domain.user.UserController;

import javax.validation.Valid;

@RequestMapping("api/users")
@RestController
public class UsersEndpoint {

    private DtoMapper dtoMapper;
    private UserController userController;

    @Autowired
    public UsersEndpoint(DtoMapper mapper, UserController userController) {
        this.dtoMapper = mapper;
        this.userController = userController;
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody @Valid UserRequestDto user) {
        System.out.println("[POST] /api/users-> user: " + user.toString());
        userController.addUser(dtoMapper.userRequestToUser(user));
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable int id) {
        System.out.println("[GET] /api/users/" + id);
        return userController.getUserById(id);
    }

    @GetMapping("{id}")
    public User getUser(@RequestParam String login) {
        System.out.println("[GET] /api/users?login=" + login);
        return userController.getUserByLogin(login);
    }
}
