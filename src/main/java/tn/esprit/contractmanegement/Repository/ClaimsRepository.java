package tn.esprit.contractmanegement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.contractmanegement.Entity.Claims;

import java.util.List;

public interface ClaimsRepository extends JpaRepository<Claims, Long> {
    List<Claims> findByUserId(Long userId);
}
