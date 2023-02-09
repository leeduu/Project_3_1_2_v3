package Project_3_1_2_v3.Project_3_1_2_v3.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "email")
    private String email;

    public User(String first_name, String last_name, String email, int id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.id = id;
    }

    public User() {}

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && first_name.equals(user.first_name) && last_name.equals(user.last_name) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, email);
    }

    @Override
    public String toString() {
        return "User{" +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id +
                '}';
    }
}
