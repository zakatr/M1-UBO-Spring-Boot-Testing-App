package com.services.impl;

import com.dtos.ResponsableDto;
import com.entities.Composante;
import com.entities.Responsable;
import com.repositories.ComposanteRepository;
import com.repositories.ResponsableRepository;
import com.services.ResponsableService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("ResponsableService")
public class ResponsableServiceImpl implements ResponsableService {
    private final ResponsableRepository responsableRepository;
    private final ComposanteRepository composanteRepository;

    public ResponsableServiceImpl(ResponsableRepository responsableRepository, ComposanteRepository composanteRepository) {
        this.responsableRepository = responsableRepository;
        this.composanteRepository = composanteRepository;
    }


    @Override
    public ResponsableDto createResponsable(ResponsableDto responsableDto, Long idComposante) {
        Composante composante = composanteRepository.findById(idComposante).orElseThrow(() -> new EntityNotFoundException("Composante not found"));
        responsableDto.setMaComposante(composante);
        Responsable responsable = responsableDtoToEntity(responsableDto);
        responsable = responsableRepository.save(responsable);
        return responsableEntityToDto(responsable);
    }

    @Override
    public ResponsableDto getResponsableById(Long responsableId) {
        Responsable responsable = responsableRepository.findById(responsableId).orElseThrow(() -> new EntityNotFoundException("Responsable not found"));
        return responsableEntityToDto(responsable);
    }

    @Override
    public boolean deleteResponsable(Long responsableId) {
        responsableRepository.deleteById(responsableId);
        return true;
    }

    @Override
    public ResponsableDto updateResponsable(ResponsableDto responsableDto, Long responsableId, Long composanteId) {
        Responsable responsable = responsableRepository.findById(responsableId).orElseThrow(() -> new EntityNotFoundException("Responsable not found"));
        Composante composante;
        if(composanteId != 0 ){
            composante = composanteRepository.findById(composanteId).orElseThrow(() -> new EntityNotFoundException("Composante not found"));
            responsable.setMaComposante(composante);
        }


        if(responsableDto.getNomUsuel() != null )
            responsable.setNomUsuel(responsableDto.getNomUsuel());

        if(responsableDto.getPrenom() != null )
            responsable.setPrenom(responsableDto.getPrenom());

        if(responsableDto.getMotDePasse() != null )
            responsable.setMotDePasse(responsableDto.getMotDePasse());

        if(responsableDto.getMail() != null )
            responsable.setMail(responsableDto.getMail());



        responsable = responsableRepository.save(responsable);
        return responsableEntityToDto(responsable);
    }

    @Override
    public List<ResponsableDto> getAllResponsable() {
        List<ResponsableDto> responsableDto = new ArrayList<>();
        List<Responsable> responsable = responsableRepository.findAll();
        responsable.forEach(vacataire -> {
            responsableDto.add(responsableEntityToDto(vacataire));
        });
        return responsableDto;
    }

    /**
     * Map responsable dto to responsable entity
     */
    private ResponsableDto responsableEntityToDto(Responsable responsable){
        ResponsableDto responsableDto = new ResponsableDto();
        responsableDto.setId(responsable.getId());
        responsableDto.setLogin(responsable.getLogin());
        responsableDto.setNomUsuel(responsable.getNomUsuel());
        responsableDto.setPrenom(responsable.getPrenom());
        responsableDto.setMotDePasse(responsable.getMotDePasse());
        responsableDto.setMail(responsable.getMail());
        responsableDto.setMaComposante(responsable.getMaComposante());
        return responsableDto;
    }

    /**
     * Map responsable entity to responsable dto
     */
    private Responsable responsableDtoToEntity(ResponsableDto responsableDto){
        Responsable responsable = new Responsable();
        responsable.setLogin(responsableDto.getLogin());
        responsable.setNomUsuel(responsableDto.getNomUsuel());
        responsable.setId(responsableDto.getId());
        responsable.setPrenom(responsableDto.getPrenom());
        responsable.setMotDePasse(responsableDto.getMotDePasse());
        responsable.setMail(responsableDto.getMail());
        responsable.setMaComposante(responsableDto.getMaComposante());
        return responsable;
    }

}
