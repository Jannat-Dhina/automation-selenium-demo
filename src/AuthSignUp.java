package src;

public class AuthSignUp {

    private String name;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String Address1;
    private String state;
    private String city;
    private String zipCode;
    private String phone;


    public AuthSignUp(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress1() {
        return Address1;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void AuthSignUpDetails(String password, String firstName, String lastName, String address1, String state, String city, String zipCode, String phone) {
        this.Address1 = address1;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

