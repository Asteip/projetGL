package com.alma.departements;

import com.alma.enseignants.*;
import java.util.ArrayList;

class Departement{
	private String nom;
	private ArrayList<Parcours> parcours;
	private ArrayList<Enseignant> enseignants;
	
	public Departement(String nom){
		this.nom = nom;
		this.parcours = new ArrayList<Parcours>();
		this.enseignants = new ArrayList<Enseignant>();
	}
	
	public void consulterDemande(){
		
	}
	
	public void validerDemande(Demande demande){
		
	}
	
	public void affecterEnseignements(Enseignant ens){
		
	}
	
	public void ImposeInterventionDepartement(){
		
	}
	
	
	
	
	
	
	// ACCESSEURS
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public void setParcours(ArrayList<Parcours> parcours){
		this.parcours = parcours;
	}
	
	public ArrayList<Parcours> getParcours(){
		return this.parcours;
	}
	
	public void setEnseignants(ArrayList<Parcours> parcours){
		this.parcours = parcours;
	}
	
	public ArrayList<Parcours> getEnseignants(){
		return this.parcours;
	}
	
	
}
