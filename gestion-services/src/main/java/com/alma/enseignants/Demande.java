package com.alma.enseignants;
public abstract class Demande {
	
	protected int id;
	private boolean publie;
	private int heures;
	private Enseignant enseignant;

	public Demande(int heures, Enseignant enseignant, int id){
		this.heures = heures;
		this.enseignant = enseignant;
		this.publie = false;
		this.id = id;
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
	
	public int getId(){
		return this.id;
	}
	
	
} 