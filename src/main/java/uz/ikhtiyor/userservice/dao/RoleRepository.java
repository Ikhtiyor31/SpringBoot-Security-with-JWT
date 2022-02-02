package uz.ikhtiyor.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ikhtiyor.userservice.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
