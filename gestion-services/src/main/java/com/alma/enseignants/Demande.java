package com.alma.enseignants;
public abstract class Demande {

	private boolean publiee;
	private int heures;
	private Enseignant enseignant;

	public Demande(int heures, Enseignant enseignant){
		this.heures = heures;
		this.enseignant = enseignant;
	}
	
	
	//--- getters and setters ---
	public boolean getPubliee(){
		return this.publiee;
	}
	public int getHeures() {
		return this.heures;
	}
	public Enseignant getEnseignant() {
		return this.enseignant;
	}
} 