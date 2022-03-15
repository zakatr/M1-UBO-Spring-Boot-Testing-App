package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Data
public class Creneau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    private Vacataire monVacataire;
    @ManyToOne
    private Cours monCours;
}
