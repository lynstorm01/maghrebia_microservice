package tn.esprit.contractmanegement.Controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.contractmanegement.Service.ReclamationResponseService;

@RestController
@RequestMapping("/api/reclamations")
public class ReclamationController {

    private final ReclamationResponseService reclamationResponseService;

    public ReclamationController(ReclamationResponseService reclamationResponseService) {
        this.reclamationResponseService = reclamationResponseService;
    }

    @PostMapping("/analyze")
    public String analyzeClaim(@RequestParam String description) {
        return reclamationResponseService.generateResponse(description);
    }

    @PostMapping("/reload-keywords")
    public String reloadKeywords() {
        reclamationResponseService.loadKeywords();
        return "Mots-clés rechargés avec succès !";
    }
}
