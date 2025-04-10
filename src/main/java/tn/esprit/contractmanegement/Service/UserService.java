package tn.esprit.contractmanegement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.contractmanegement.Entity.Appointement;
import tn.esprit.contractmanegement.Entity.Claims;
import tn.esprit.contractmanegement.Entity.User;
import tn.esprit.contractmanegement.Repository.AppointementRepository;
import tn.esprit.contractmanegement.Repository.ClaimsRepository;
import tn.esprit.contractmanegement.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService, UserDetailsService {

    private final UserRepository userRepository;
    private final AppointementRepository appointementRepository;
    private final ClaimsRepository claimsRepository;

    @Autowired
    public UserService(UserRepository userRepository, AppointementRepository appointementRepository, ClaimsRepository claimsRepository) {
        this.userRepository = userRepository;
        this.appointementRepository = appointementRepository;
        this.claimsRepository = claimsRepository;
    }

    // ✅ Affecter un rendez-vous à un utilisateur
    @Override
    public User assignAppointmentToUser(Long userId, Appointement appointment) {
        return userRepository.findById(userId).map(user -> {
            appointment.setUser(user);
            appointementRepository.save(appointment);
            return user;
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // ✅ Affecter une réclamation à un utilisateur
    @Override
    public User assignClaimToUser(Long userId, Claims claim) {
        return userRepository.findById(userId).map(user -> {
            claim.setUser(user);
            claimsRepository.save(claim);
            return user;
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }


    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setPassword(updatedUser.getPassword()); // ensure password is encoded
            user.setRole(updatedUser.getRole());
            user.setEmail(updatedUser.getEmail());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Implementation for Spring Security's UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name())  // Convert the Role enum to a String
                .build();
    }
}