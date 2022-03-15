package com.dtos;

import com.entities.Cours;
import com.entities.Vacataire;
import com.entities.TypeCreneau;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class CreneauDto {
    private Long idCreneau;
    private LocalDateTime date_heure;
    private Duration duree;
    private TypeCreneau type;
    private Boolean estEffectue  = false;
    private Duration dureeEffective;
    private Boolean valide  = false;
    private String commentaire;
    private String photo;
    private String salle;
    private Vacataire monVacataire;
    private Cours monCours;
}
