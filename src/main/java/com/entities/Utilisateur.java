package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Utilisateur {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String motDePasse;
	private String nomUsuel;
	private String prenom;
	private String mail;
}
