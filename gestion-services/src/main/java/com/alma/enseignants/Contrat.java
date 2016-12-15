package com.alma.enseignants;

import java.util.List;

public class Contrat {
	private int min;
	private int max;
	private List<Enseignant> enseignants; //c'est chelou ca aussi
	
	public Contrat(int min, int max){
		this.min = min;
		this.max = max;
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

	public List<Enseignant> getEnseignants() {
		return enseignants;
	}
	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}
	
	
}
