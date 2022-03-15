package com.services;

import com.dtos.CreneauDto;

import java.util.List;

public interface CreneauService {
    /**
     * Créer un creneau
     */
    CreneauDto createCreneau(CreneauDto creneauDto, Long vacataireId, Long CoursId);

    /**
     * Retourner un creneau
     */
    CreneauDto getCreneauById(Long creneauId);

    /**
     * Modifier un creneau
     */
    CreneauDto updateCreneauById(Long creneauId, CreneauDto creneauDto);

    /**
     * Supprimer un creneau
     */
    boolean deleteCreneau(Long creneauId);

    /**
     * Retourner tous les creneau
     */
    List<CreneauDto> getAllCreneau();
}

