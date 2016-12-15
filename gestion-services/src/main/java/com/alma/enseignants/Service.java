package com.alma.enseignants;

import java.util.List;

public class Service {
	
	private int volume;
	private int annee;
	private List<Intervention> interventions;
	
	public Service(int volume, int annee){
		this.volume = volume;
		this.annee = annee;
	}

	//--- getters and setters ---
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	
}
