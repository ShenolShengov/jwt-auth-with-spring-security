package bg.about_java.jwt_auth_with_spring_security.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity {

    @Column(nullable = false, unique = true, length = 70)
    private String username;

    @Column(nullable = false, length = 70)
    private String password;

    @Column(nullable = false, length = 70)
    private String email;

    @ManyToMany
    @JoinTable(inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    public User() {
        this.roles = new HashSet<>();
    }
}
