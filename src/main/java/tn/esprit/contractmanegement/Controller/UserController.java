package tn.esprit.contractmanegement.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.contractmanegement.Entity.Appointement;
import tn.esprit.contractmanegement.Entity.Claims;
import tn.esprit.contractmanegement.Entity.User;
import tn.esprit.contractmanegement.Service.UserService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ✅ Affecter un rendez-vous à un utilisateur
    @PostMapping("/{userId}/appointments")
    public ResponseEntity<String> assignAppointment(@PathVariable Long userId, @RequestBody Appointement appointment) {
        try {
            userService.assignAppointmentToUser(userId, appointment);
            return ResponseEntity.ok("Appointment assigned successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // ✅ Affecter une réclamation à un utilisateur
    @PostMapping("/{userId}/claims")
    public ResponseEntity<String> assignClaim(@PathVariable Long userId, @RequestBody Claims claim) {
        try {
            userService.assignClaimToUser(userId, claim);
            return ResponseEntity.ok("Claim assigned successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // ✅ Création d'un utilisateur (Inscription)
    @PostMapping
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
        try {
            User createdUser = userService.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // ✅ Récupération de tous les utilisateurs
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(users);
    }

    // ✅ Récupération d'un utilisateur par ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // ✅ Mise à jour d'un utilisateur
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User updatedUser) {
        try {
            User user = userService.updateUser(id, updatedUser);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // ✅ Suppression d'un utilisateur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.getUserById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Recherche d'un utilisateur par username
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userService.getUsername(username);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
