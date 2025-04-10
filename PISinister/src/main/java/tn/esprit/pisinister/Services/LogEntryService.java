package tn.esprit.pisinister.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pisinister.Entity.LogEntry;
import tn.esprit.pisinister.Repository.LogEntryRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogEntryService {

    @Autowired
    private LogEntryRepository logEntryRepository;

    // Log a new user action
    public void logAction(String action, String description, String username, String userRole) {
        LogEntry logEntry = new LogEntry();
        logEntry.setAction(action);
        logEntry.setDescription(description);
        logEntry.setTimestamp(LocalDateTime.now());
        logEntry.setUsername(username);
        logEntry.setUserRole(userRole);
        logEntryRepository.save(logEntry);
    }

    // Retrieve all logs
    public List<LogEntry> getAllLogs() {
        return logEntryRepository.findAll();
    }

    // Retrieve logs by user role (optional)
    public List<LogEntry> getLogsByUserRole(String userRole) {
        return logEntryRepository.findByUserRole(userRole);
    }
}
