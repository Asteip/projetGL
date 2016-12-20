package com.alma.enseignants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Demande {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private boolean publie;
	private int heures;
	private Enseignant enseignant;

	protected Demande() {}
	
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
	
	public long getId(){
		return this.id;
	}
	
	public void setPublie(boolean publie) {
		this.publie = publie;
	}
	
	
	
	
	
	
	
} 


