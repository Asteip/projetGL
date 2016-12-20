package com.alma.enseignants;

public class DemandeInterExt extends Demande{

	private String organisation;
	
	public DemandeInterExt(int heures, Enseignant enseignant, String organisation, long id) {
		super(heures, enseignant, id);
		this.organisation = organisation;
	}

	
	//--- getters and setters ---
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

}
