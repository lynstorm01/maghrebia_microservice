package tn.esprit.pisinister.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pisinister.Entity.Users;
import tn.esprit.pisinister.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get user by ID
    public Users getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Get all users
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    // Create or update a user
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
