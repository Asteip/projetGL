package com.alma.departements;

public class Module{
	
	private Parcours parcours;
	
	public Module(Parcours parcours) {
		this.parcours = parcours;
	}
	
	public Parcours getParcours() {
		return this.parcours;
	}
}
