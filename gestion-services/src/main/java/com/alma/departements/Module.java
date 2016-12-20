package com.alma.departements;

public class Module{
	
	private Parcours parcours;
	private Enseignement enseignement;
	
	public Module(Parcours parcours, Enseignement en) {
		this.parcours = parcours;
		this.enseignement = en;
	}
	
	public Parcours getParcours() {
		return this.parcours;
	}

	public Enseignement getEnseignement() {
		return enseignement;
	}
	
}
