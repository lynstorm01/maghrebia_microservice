package tn.esprit.pisinister.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.pisinister.Entity.LogEntry;

import java.util.List;

public interface LogEntryRepository extends JpaRepository<LogEntry, Long> {
    List<LogEntry> findByUserRole(String userRole); // Optional: Filter logs by user role
}