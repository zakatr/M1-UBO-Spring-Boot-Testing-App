package com.services.impl;

import com.dtos.CreneauDto;
import com.entities.Cours;
import com.entities.Creneau;
import com.entities.Vacataire;
import com.repositories.CoursRepository;
import com.repositories.VacataireRepository;
import com.repositories.CreneauRepository;
import com.services.CreneauService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("CreneauService")
public class CreneauServiceImpl implements CreneauService {
    private final CreneauRepository creneauRepository;
    private final CoursRepository coursRepository;
    private final VacataireRepository vacataireRepository;

    public CreneauServiceImpl(CreneauRepository creneauRepository, CoursRepository coursRepository, VacataireRepository vacataireRepository) {
        this.creneauRepository = creneauRepository;
        this.coursRepository = coursRepository;
        this.vacataireRepository = vacataireRepository;
    }


    @Override
    public CreneauDto createCreneau(CreneauDto creneauDto, Long idVacataire, Long idCours) {
        Cours cours = coursRepository.findById(idCours).orElseThrow(() -> new EntityNotFoundException("Cours not found"));
        Vacataire vacataire = vacataireRepository.findById(idVacataire).orElseThrow(() -> new EntityNotFoundException("Vacataire not found"));
        creneauDto.setMonCours(cours);
        creneauDto.setMonVacataire(vacataire);
        Creneau creneau = creneauDtoToEntity(creneauDto);
        creneau = creneauRepository.save(creneau);
        return creneauEntityToDto(creneau);
    }

    @Override
    public CreneauDto getCreneauById(Long creneauId) {
        Creneau creneau = creneauRepository.findById(creneauId).orElseThrow(() -> new EntityNotFoundException("Creneau not found"));
        return creneauEntityToDto(creneau);
    }

    @Override
    public boolean deleteCreneau(Long creneauId) {
        creneauRepository.deleteById(creneauId);
        return true;
    }

    @Override
    public CreneauDto updateCreneauById(Long creneauId, CreneauDto creneauDto) {
        Creneau creneau = creneauRepository.findById(creneauId).orElseThrow(() -> new EntityNotFoundException("Creneau not found"));

        if(creneauDto.getCommentaire() != null )
            creneau.setCommentaire(creneauDto.getCommentaire());

        if(creneauDto.getDuree() != null )
            creneau.setDuree(creneauDto.getDuree());

        if(creneauDto.getDureeEffective() != null )
            creneau.setDureeEffective(creneauDto.getDureeEffective());

        if(creneauDto.getDate_heure() != null )
            creneau.setDate_heure(creneauDto.getDate_heure());

        if(creneauDto.getEstEffectue() != null )
            creneau.setEstEffectue(creneauDto.getEstEffectue());

        if(creneauDto.getPhoto() != null )
            creneau.setPhoto(creneauDto.getPhoto());

        if(creneauDto.getSalle() != null )
            creneau.setSalle(creneauDto.getSalle());

        if(creneauDto.getType() != null )
            creneau.setType(creneauDto.getType());

        if(creneauDto.getValide() != null )
            creneau.setValide(creneauDto.getValide());

        if(creneauDto.getMonCours() != null )
            creneau.setMonCours(creneauDto.getMonCours());

        if(creneauDto.getMonVacataire() != null )
            creneau.setMonVacataire(creneauDto.getMonVacataire());

        creneau = creneauRepository.save(creneau);
        return creneauEntityToDto(creneau);
    }

    @Override
    public List<CreneauDto> getAllCreneau() {
        List<CreneauDto> creneauDto = new ArrayList<>();
        List<Creneau> creneau = creneauRepository.findAll();
        creneau.forEach(elt -> {
            creneauDto.add(creneauEntityToDto(elt));
        });
        return creneauDto;
    }

    /**
     * Map creneau dto to creneau entity
     */
    private CreneauDto creneauEntityToDto(Creneau creneau){
        CreneauDto creneauDto = new CreneauDto();
        creneauDto.setCommentaire(creneau.getCommentaire());
        creneauDto.setDuree(creneau.getDuree());
        creneauDto.setDate_heure(creneau.getDate_heure());
        creneauDto.setDureeEffective(creneau.getDureeEffective());
        creneauDto.setEstEffectue(creneau.getEstEffectue());
        creneauDto.setPhoto(creneau.getPhoto());
        creneauDto.setSalle(creneau.getSalle());
        creneauDto.setType(creneau.getType());
        creneauDto.setValide(creneau.getValide());
        creneauDto.setMonVacataire(creneau.getMonVacataire());
        creneauDto.setMonCours(creneau.getMonCours());
        return creneauDto;
    }

    /**
     * Map creneau entity to creneau dto
     */
    private Creneau creneauDtoToEntity(CreneauDto creneauDto){
        Creneau creneau = new Creneau();
        creneau.setCommentaire(creneauDto.getCommentaire());
        creneau.setDuree(creneauDto.getDuree());
        creneau.setDate_heure(creneauDto.getDate_heure());
        creneau.setDureeEffective(creneauDto.getDureeEffective());
        creneau.setEstEffectue(creneauDto.getEstEffectue());
        creneau.setPhoto(creneauDto.getPhoto());
        creneau.setSalle(creneauDto.getSalle());
        creneau.setType(creneauDto.getType());
        creneau.setValide(creneauDto.getValide());
        creneau.setMonVacataire(creneauDto.getMonVacataire());
        creneau.setMonCours(creneauDto.getMonCours());
        return creneau;
    }

}
