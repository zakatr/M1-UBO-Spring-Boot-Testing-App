package com.controllers;

import com.dtos.ResponsableDto;
import com.services.impl.ResponsableServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/badgeuse/responsable")
public class ResponsableController {

    private final ResponsableServiceImpl responsableService;

    public ResponsableController(ResponsableServiceImpl responsableService) {this.responsableService = responsableService;}

    /**
     * <p>Get all responsables in the system</p>
     * @return List<GestionnaresDto>
     */
    @GetMapping
    public List<ResponsableDto> getResponsables() {
        return responsableService.getAllResponsable();
    }

    /**
     * Method to get the responsable based on the ID
     */
    @GetMapping("/{id}")
    public ResponsableDto getResponsable(@PathVariable Long id){return responsableService.getResponsableById(id);}

    /**
     * Create a new Responsable in the system with idComposante
     */
    @PostMapping("/")
    public ResponsableDto createResponsable(final @RequestBody ResponsableDto responsableDto, @RequestParam Long id){
        return responsableService.createResponsable(responsableDto, id);
    }

    /**
     * Update a Responsable in the system
     */
    @PutMapping("/")
    public ResponsableDto updateResponsable(final @RequestBody ResponsableDto responsableDto, @RequestParam Long id, @RequestParam Long idComposante){
        return responsableService.updateResponsable(responsableDto,id,idComposante);
    }

    /**
     * Delete a responsable by its id
     */
    @DeleteMapping("/")
    public Boolean deleteResponsable(@RequestParam Long id){
        return responsableService.deleteResponsable(id);
    }

}
