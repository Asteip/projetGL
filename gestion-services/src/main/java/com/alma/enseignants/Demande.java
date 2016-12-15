package com.alma.enseignants;
public abstract class Demande {

	private boolean publie;
	private int heures;
	private Enseignant enseignant;

	public Demande(int heures, Enseignant enseignant){
		this.heures = heures;
		this.enseignant = enseignant;
		this.publie = false;
	}
	
	
	//--- getters and setters ---
	public boolean getPublie(){
		return this.publie;
	}
	public int getHeures() {
		return this.heures;
	}
	public Enseignant getEnseignant() {
		return this.enseignant;
	}
} 