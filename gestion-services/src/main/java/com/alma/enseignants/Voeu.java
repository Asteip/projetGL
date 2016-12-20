package com.alma.enseignants;

import com.alma.departements.Enseignement;

public class Voeu extends Demande{

	private int preference;
	private Enseignement enseignement;
	
	public Voeu(int heures, Enseignant enseignant, int preference, Enseignement enseignement, int id) {
		super(heures, enseignant, id);
		this.preference = preference;
		this.enseignement = enseignement;
	}

	
	//--- getters and setters ---
	public int getPreference() {
		return preference;
	}
	public void setPreference(int preference) {
		this.preference = preference;
	}

	public Enseignement getEnseignement() {
		return enseignement;
	}
	public void setEnseignement(Enseignement enseignement) {
		this.enseignement = enseignement;
	}

	
	
}
