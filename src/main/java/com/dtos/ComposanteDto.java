package com.dtos;

import com.entities.Filiere;
import com.entities.Responsable;
import lombok.Data;

import java.util.List;

@Data
public class ComposanteDto {
    private Long idComposante;
    private String nomComposante;
    private List<Filiere> lesFilieres;
    private List<Responsable> lesResponsables;
}
