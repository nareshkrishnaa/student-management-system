package nk.sms.dto;

public class SignupDto {
    private String name;
    private String email;
    private String password;
    private String signupType;

    public SignupDto(String name, String email, String password, String signupType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.signupType = signupType;
    }

    public SignupDto() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSignupType() {
        return signupType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSignupType(String signupType) {
        this.signupType = signupType;
    }

    public String toString() {
        return "SignupDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='****'" +
                ", signupType='" + signupType + '\'' +
                '}';
    }

}
