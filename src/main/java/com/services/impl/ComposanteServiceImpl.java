package com.services.impl;

import com.dtos.ComposanteDto;
import com.entities.Composante;
import com.repositories.ComposanteRepository;
import com.repositories.FiliereRepository;
import com.repositories.ResponsableRepository;
import com.services.ComposanteService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("composanteService")
public class ComposanteServiceImpl implements ComposanteService {
    private final ComposanteRepository composanteRepository;

    public ComposanteServiceImpl(ComposanteRepository composanteRepository, ResponsableRepository responsableRepository, FiliereRepository filiereRepository){
        this.composanteRepository = composanteRepository;
    }

    @Override
    public ComposanteDto createComposante(ComposanteDto composanteDto) {
        Composante composante = composanteDtoToEntity(composanteDto);
        composante = composanteRepository.save(composante);
        return composanteEntityToDto(composante);
    }

    @Override
    public ComposanteDto getComposanteById(Long composanteId) {
        Composante composante = composanteRepository.findById(composanteId).orElseThrow(() -> new EntityNotFoundException("Composante not found"));
        return composanteEntityToDto(composante);
    }

    @Override
    public ComposanteDto updateComposanteById(Long composanteId, ComposanteDto composanteDto) {
        Composante composante = composanteRepository.findById(composanteId).orElseThrow(() -> new EntityNotFoundException("Composante not found"));
        if(composanteDto.getNomComposante() != null)
            composante.setNomComposante(composanteDto.getNomComposante());
        composante = composanteRepository.save(composante);
        return composanteEntityToDto(composante);
    }

    @Override
    public boolean deleteComposante(Long composanteId) {
        composanteRepository.deleteById(composanteId);
        return true;
    }

    @Override
    public List<ComposanteDto> getAllComposante() {
        List<ComposanteDto> composanteDtos = new ArrayList<>();
        List<Composante> lesComposante = composanteRepository.findAll();
        lesComposante.forEach(composante -> {
            composanteDtos.add(composanteEntityToDto(composante));
        });
        return composanteDtos;
    }

    /**
     * Map composante dto to composante entity
     */
    private ComposanteDto composanteEntityToDto(Composante composante){
        ComposanteDto composanteDto = new ComposanteDto();
        composanteDto.setIdComposante(composante.getIdComposante());
        composanteDto.setNomComposante(composante.getNomComposante());
        composanteDto.setLesFilieres(composante.getLesFilieres());
        composanteDto.setLesResponsables(composante.getLesResponsables());
        return composanteDto;
    }

    /**
     * Map composante entity to composante dto
     */
    private Composante composanteDtoToEntity(ComposanteDto composanteDto){
        Composante composante = new Composante();
        composante.setIdComposante(composanteDto.getIdComposante());
        composante.setNomComposante(composanteDto.getNomComposante());
        composante.setLesFilieres(composanteDto.getLesFilieres());
        composante.setLesResponsables(composanteDto.getLesResponsables());
        return composante;
    }
}
