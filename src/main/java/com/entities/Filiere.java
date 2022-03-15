package com.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Entity
@Data
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFiliere;
    @Column(unique=true)
    private String codeFiliere;
    @Column(unique=true)
    private String nomFiliere;
    @ManyToOne
    @JoinColumn(name = "id_composante")
    @JsonBackReference
    private Composante maComposante;
}
