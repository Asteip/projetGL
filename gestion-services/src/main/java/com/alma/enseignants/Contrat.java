package com.alma.enseignants;

import java.util.ArrayList;


public class Contrat {
	private int min;
	private int max;
	private ArrayList<Enseignant> enseignants; //
	
	public Contrat(int min, int max){
		this.min = min;
		this.max = max;
		this.enseignants = new ArrayList<Enseignant>();
	}

	public void addEnseignant(Enseignant e){
		this.enseignants.add(e);
	}
	public void removeEnseignant(Enseignant e){
		this.enseignants.remove(e);
	}
	
	//--- getters and setters ---
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}

	public ArrayList<Enseignant> getEnseignants() {
		return enseignants;
	}
	public void setEnseignants(ArrayList<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}
	
	
}
