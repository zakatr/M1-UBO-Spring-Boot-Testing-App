package com.controllers;

import com.dtos.CreneauDto;
import com.services.impl.CreneauServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/badgeuse/creneau")
public class CreneauController {

    private final CreneauServiceImpl creneauService;

    public CreneauController(CreneauServiceImpl creneauService) {this.creneauService = creneauService;}

    /**
     * <p>Get all creneaus in the system</p>
     * @return List<GestionnaresDto>
     */
    @GetMapping
    public List<CreneauDto> getAllCreneau() {
        return creneauService.getAllCreneau();
    }

    /**
     * Method to get the creneau based on the ID
     */
    @GetMapping("/{id}")
    public CreneauDto getCreneau(@PathVariable Long id){return creneauService.getCreneauById(id);}

    /**
     * Create a new Creneau in the system with idComposante
     */
    @PostMapping("/")
    public CreneauDto createCreneau(final @RequestBody CreneauDto creneauDto, @RequestParam Long idVacataire, @RequestParam Long idCours){
        return creneauService.createCreneau(creneauDto, idVacataire, idCours);
    }

    /**
     * Update a Creneau in the system
     */
    @PutMapping("/update/")
    public CreneauDto updateCreneau(final @RequestBody CreneauDto creneauDto, @RequestParam Long id){
        return creneauService.updateCreneauById(id, creneauDto);
    }

    /**
     * Delete a creneau by its id
     */
    @DeleteMapping("/")
    public Boolean deleteCreneau(@RequestParam Long id){
        return creneauService.deleteCreneau(id);
    }

}
