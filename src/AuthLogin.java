package src;

public class AuthLogin {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public AuthLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
