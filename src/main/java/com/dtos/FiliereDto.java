package com.dtos;

import com.entities.Composante;
import lombok.Data;

@Data
public class FiliereDto {
    private Long idFiliere;
    private String codeFiliere;
    private String nomFiliere;
    private Composante maComposante;
}
