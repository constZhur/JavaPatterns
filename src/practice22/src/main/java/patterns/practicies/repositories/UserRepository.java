package patterns.practicies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import patterns.practicies.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Integer> {
    Optional<User> findUserByEmail(String email);


}
