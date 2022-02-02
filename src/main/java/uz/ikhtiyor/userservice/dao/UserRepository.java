package uz.ikhtiyor.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ikhtiyor.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
