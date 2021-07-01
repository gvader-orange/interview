package pl.example.codereview.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequestDto {

    @NotNull(message = "Password can't be null")
    private String password;
    private String name;
    private String mail;
    private String phone;
    @NotNull(message = "Login can't be null")
    private String login;
    private boolean admin;

    public UserRequestDto(String password, String name, String mail, String phone, String login, boolean admin) {
        this.password = password;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.login = login;
        this.admin = admin;
    }

    public UserRequestDto() {
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getLogin() {
        return login;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return "UserRequestDto{" +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin='" + admin + '\'' +
                '}';
    }
}
