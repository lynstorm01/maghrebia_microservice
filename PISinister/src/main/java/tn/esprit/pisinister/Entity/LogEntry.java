package tn.esprit.pisinister.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_entries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String action; // E.g., "Approved Sinister", "Updated Claim"

    @Column(nullable = false)
    private String description; // E.g., "Admin X approved Sinister #123"

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private String username; // Username of the user who performed the action

    @Column(nullable = false)
    private String userRole; // Role of the user (e.g., ADMIN, CLIENT)
}