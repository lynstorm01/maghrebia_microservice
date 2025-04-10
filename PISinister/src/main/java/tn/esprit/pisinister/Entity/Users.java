package tn.esprit.pisinister.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Date of incident is required")
    @PastOrPresent(message = "Date of incident cannot be in the future")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofregistration;

    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Type is required")
    private UsersType type = UsersType.CLIENT;

    @NotBlank(message = "Firstname cannot be blank")
    private String firstname;
    private String lastname;
    private String password;
    private String phonenumber;
    private String username;

  /*  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("user")
    private List<Sinister> sinisters;*/
}
