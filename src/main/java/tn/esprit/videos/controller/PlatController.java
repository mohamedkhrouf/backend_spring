package tn.esprit.videos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.videos.entity.Plat;

import tn.esprit.videos.service.PlatService;
import tn.esprit.videos.service.UserService;

import java.util.List;
import java.util.concurrent.ExecutionException;
@RestController
public class PlatController {
        @Autowired
        PlatService platService;
        @GetMapping("/getPlatsDetails")
        public List<Plat> getPlats() throws InterruptedException, ExecutionException {
            return platService.getPlatsDetails();
        }
        @GetMapping("/getPlatDetails/{id}")
        public Plat getPlat(@RequestParam String id ) throws InterruptedException, ExecutionException {
            return platService.getPlatDetails(id);
        }
        @PostMapping("/createPlat")
        public String createPlat(@RequestBody Plat plat ) throws InterruptedException, ExecutionException {
            return platService.savePlatDetails(plat);
        }
        @PutMapping("/updatePlat")
        public String updateUser(@RequestBody Plat plat ) throws InterruptedException, ExecutionException {
            return platService.updatePlatDetails(plat);
        }
        @DeleteMapping("/deletePlat/{id}")
        public String deletePlat(@RequestParam String id){
            return platService.deletePlat(id);
        }

}
