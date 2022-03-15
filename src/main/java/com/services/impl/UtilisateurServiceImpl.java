package com.services.impl;

import com.dtos.UtilisateurDto;
import com.entities.Utilisateur;
import com.repositories.UtilisateurRepository;
import com.services.UtilisateurService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("utilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDto) {
        // Converts the dto to the utilisateur entity
        Utilisateur utilisateur = utilisateurDtoToEntity(utilisateurDto);
        // Save the utilisateur entity
        utilisateur = utilisateurRepository.save(utilisateur);
        // Return the new dto
        return utilisateurEntityToDto(utilisateur);
    }

    @Override
    public UtilisateurDto getUtilisateurById(Long utilisateurId) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));
        return utilisateurEntityToDto(utilisateur);
    }

    @Override
    public boolean deleteUtilisateur(Long utilisateurId) {
        utilisateurRepository.deleteById(utilisateurId);
        return true;
    }

    @Override
    public List<UtilisateurDto> getAllUtilisateurs() {
        List<UtilisateurDto> utilisateurDtos = new ArrayList<>();
        List<Utilisateur> lesUtilisateurs = utilisateurRepository.findAll();
        lesUtilisateurs.forEach(utilisateur -> {
            utilisateurDtos.add(utilisateurEntityToDto(utilisateur));
        });
        return utilisateurDtos;
    }

    /**
     * Map utilisateur dto to utilisateur entity
     */
    private UtilisateurDto utilisateurEntityToDto(Utilisateur utilisateur){
        UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setId(utilisateur.getId());
        utilisateurDto.setLogin(utilisateur.getLogin());
        utilisateurDto.setMotDePasse(utilisateur.getMotDePasse());
        utilisateurDto.setNomUsuel(utilisateur.getNomUsuel());
        utilisateurDto.setPrenom(utilisateur.getPrenom());
        utilisateurDto.setMail(utilisateur.getMail());
        return utilisateurDto;
    }

    /**
     * Map utilisateur entity to utilisateur dto
     */
    private Utilisateur utilisateurDtoToEntity(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setLogin(utilisateurDto.getLogin());
        utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
        utilisateur.setNomUsuel(utilisateurDto.getNomUsuel());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setMail(utilisateurDto.getMail());
        return utilisateur;
    }
}
