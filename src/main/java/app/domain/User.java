package app.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private boolean active;

    @Setter(AccessLevel.NONE)
    private String password;

    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }

    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)
    private Set<Roles> roles;
}