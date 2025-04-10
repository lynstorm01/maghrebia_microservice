package tn.esprit.contractmanegement.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SatisfactionSurvey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long claimId;
    private Long userId;
    private int csatScore; // 1-5 or other scale for CSAT
    private String feedback; // optional feedback
    private String sentimentAnalysis;
}
