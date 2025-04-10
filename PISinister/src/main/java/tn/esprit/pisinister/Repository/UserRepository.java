package tn.esprit.pisinister.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.pisinister.Entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    // You can add custom queries here if needed
}
