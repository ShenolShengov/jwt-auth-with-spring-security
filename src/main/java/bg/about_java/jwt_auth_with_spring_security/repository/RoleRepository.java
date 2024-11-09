package bg.about_java.jwt_auth_with_spring_security.repository;

import bg.about_java.jwt_auth_with_spring_security.domain.entity.Role;
import bg.about_java.jwt_auth_with_spring_security.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getByName(String name);
}
