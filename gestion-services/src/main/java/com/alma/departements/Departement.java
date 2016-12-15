package departements;

import enseignants;
import java.util.ArrayList;

class Departement{
	private String nom;
	private ArrayList<Parcours> parcours;
	private ArrayList<Enseignant> enseignants;
	
	public Departement(){
		
	}
	
	public void consulterDemande(){
		
	}
	
	
	
	
	
	// ACCESSEURS
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public String getNom(){
		return this.nom;
	}
}
