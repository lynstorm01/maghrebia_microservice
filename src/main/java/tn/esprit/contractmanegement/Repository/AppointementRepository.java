package tn.esprit.contractmanegement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.contractmanegement.Entity.Appointement;

import java.time.LocalDate;
import java.util.List;

public interface AppointementRepository extends JpaRepository<Appointement, Long> {
    // Renvoie uniquement les appointments à afficher (archiver = true)
    List<Appointement> findByArchiverTrue();
    List<Appointement> findByUserId(Long userId);
    // Méthode pour compter le nombre de rendez-vous pour une date donnée
    @Query("SELECT COUNT(a) FROM Appointement a WHERE FUNCTION('DATE', a.dateSubmitted) = :date")
    long countByDateSubmitted(@Param("date") LocalDate date);


    List<Appointement> findByStatus(String status);




}
