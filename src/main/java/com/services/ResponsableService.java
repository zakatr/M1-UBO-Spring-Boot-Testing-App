package com.services;

import com.dtos.ResponsableDto;

import java.util.List;

public interface ResponsableService {
    /**
     * Créer un responsable
     */
    ResponsableDto createResponsable(ResponsableDto responsableDto, Long idComposante);

    /**
     * Retourner un responsable
     */
    ResponsableDto getResponsableById(Long responsableId);

    /**
     * Supprimer un responsable
     */
    boolean deleteResponsable(Long responsableId);

    /**
     * Modifie un responsable
     */
    ResponsableDto updateResponsable(ResponsableDto responsableDto, Long responsableId, Long idComposante);

    /**
     * Retourner tous les responsable
     */
    List<ResponsableDto> getAllResponsable();
}
