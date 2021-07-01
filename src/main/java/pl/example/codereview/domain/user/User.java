package pl.example.codereview.domain.user;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;
    private String name;
    private String mail;
    private String phone;
    @Column(unique = true)
    private String login;
    private boolean isAdmin;

    public User(String name, String password, String mail, String phone, String login) {
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
        this.login = login;
    }

    public User(String name, String password, String mail, String phone, String login, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
        this.login = login;
        this.isAdmin = isAdmin;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
