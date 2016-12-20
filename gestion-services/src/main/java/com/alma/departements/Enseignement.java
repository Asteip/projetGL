package com.alma.departements;

import java.util.Calendar;



public class Enseignement{
	private int volumeHoraire;
	private Module module;
	private int typeEnseignement;
	
	/**
	 * Instancie un nouvel enseignement.
	 * @param volumeHoraire Le nombre d'heures de l'enseignement.
	 * @param module Le module concerné (Ex : Génie Logiciel).
	 * @param typeEnseignement Entier parmi les constantes définies dans la classe TypeEnseignement. Cet entier représentera un CM/TD/TP.
	 */
	public Enseignement(int volumeHoraire, Module module, int typeEnseignement) {
		this.volumeHoraire = volumeHoraire;
		this.module = module;
		this.typeEnseignement = typeEnseignement;
		
	}
	
	/**
	 * Accesseur pour l'attribut volumeHoraire.
	 * @return Le volume horaire de l'Enseignement.
	 */
	public int getVolumeHoraire() {
		return this.volumeHoraire;
	}
	
	/**
	 * Accesseur pour l'attribut module.
	 * @return L'objet Module de l'Enseignement.
	 */
	public Module getModule() {
		return this.module;
	}
	
	public int getTypeEnseignement() {
		return this.typeEnseignement;
		
	}
	
	/**
	 * Retourne le type d'enseignement.
	 * @return La chaîne de caractère correspondant à l'attribut typeEnseignement soit : CM / TD / TP.
	 */
	public String getTypeEnseignementStr() {
		String ret = "";
		
		// Une exception est levée si le type d'enseignement est inconnu.
		try {
			ret = TypeEnseignement.getType(typeEnseignement);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return ret;
	}
	
}
