package com.services;

import com.dtos.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    /**
     * Save a user
     */
    UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDto);

    /**
     * Get a user by its id
     */
    UtilisateurDto getUtilisateurById(Long utilisateurId);

    /**
     * Delete a user by its id
     */
    boolean deleteUtilisateur(Long utilisateurId);

    /**
     * Get all the users
     */
    List<UtilisateurDto> getAllUtilisateurs();


}