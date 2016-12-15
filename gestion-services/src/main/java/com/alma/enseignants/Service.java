package com.alma.enseignants;

import java.util.ArrayList;
import java.util.List;

public class Service {
	
	private int volume;
	private int annee;
	private List<Intervention> interventions;
	
	public Service(int volume, int annee){
		this.volume = volume;
		this.annee = annee;
		this.interventions = new ArrayList<Intervention>();
	}

	public void addIntervention(Intervention i){
		interventions.add(i);
	}
	
	public void removeIntervention(Intervention i){
		interventions.remove(i);
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

	public List<Intervention> getInterventions() {
		return interventions;
	}
	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	
	
	
}
