package bg.about_java.jwt_auth_with_spring_security.repository;

import bg.about_java.jwt_auth_with_spring_security.domain.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity getByName(String name);
}
