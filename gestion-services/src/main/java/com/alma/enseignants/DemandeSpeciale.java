package com.alma.enseignants;

public class DemandeSpeciale extends Demande {
	private String type;
	
	public DemandeSpeciale(int heures, Enseignant enseignant, String type){
		super(heures, enseignant);
		this.type = type;
	}
	
	
	//--- getters and setters ---
	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type = type;
	}
}