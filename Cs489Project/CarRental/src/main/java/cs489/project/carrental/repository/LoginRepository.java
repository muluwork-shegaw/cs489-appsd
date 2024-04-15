package cs489.project.carrental.repository;

import cs489.project.carrental.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {
    // You might want to add a method to find a user by email for authentication purposes
    Optional<Login> findByEmail(String email);
}
