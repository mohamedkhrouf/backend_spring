package tn.esprit.videos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.videos.entity.Commande;
import tn.esprit.videos.service.CommandeService;


import java.util.List;
import java.util.concurrent.ExecutionException;
@RestController
public class CommandeController {
    @Autowired
    CommandeService commandeService;
    @GetMapping("/getCommandesDetails")
    public List<Commande> getCommandes() throws InterruptedException, ExecutionException {
        return commandeService.getCommandesDetails();
    }
    @GetMapping("/getCommandeDetails/{id}")
    public Commande getCommande(@RequestParam String id ) throws InterruptedException, ExecutionException {
        return commandeService.getCommandeDetails(id);
    }
    @PostMapping("/createCommande")
    public String createCommande(@RequestBody Commande commande ) throws InterruptedException, ExecutionException {
        return commandeService.saveCommandeDetails(commande);
    }
    @PutMapping("/updateCommande")
    public String updateCommande(@RequestBody Commande commande ) throws InterruptedException, ExecutionException {
        return commandeService.updateCommandeDetails(commande);
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@RequestParam String id){
        return commandeService.deleteCommande(id);
    }
}
