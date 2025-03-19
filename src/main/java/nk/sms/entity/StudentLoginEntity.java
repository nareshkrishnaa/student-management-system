package nk.sms.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student_login_table")
public class StudentLoginEntity {
    @Id
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    @Override
    public String toString() {
        return "StudentLoginEntity{ email='" + email + "', password='" + password + "'}";
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
