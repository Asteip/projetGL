package com.alma.departements;

import com.alma.enseignants.*;

import java.util.ArrayList;
import java.util.Calendar;

public class Departement{
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
	
	public void affecterDemande(Demande demande){
		Intervention i;
		
		if (demande instanceof Voeu) {
			i = new InterventionDep(demande.getHeures(), new Service(demande.getHeures(), Calendar.getInstance().get(Calendar.YEAR)));
		}
		else if (demande instanceof DemandeSpeciale) {
			i = new CasSpecial(demande.getHeures(), new Service(demande.getHeures(), Calendar.getInstance().get(Calendar.YEAR)));
		}
		else if (demande instanceof DemandeInterExt) {
			i = new InterventionExt(demande.getHeures(), new Service(demande.getHeures(), Calendar.getInstance().get(Calendar.YEAR)));
		}
	}
	
	public void ImposeInterventionDepartement(Enseignant ens, Enseignement e){
		
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
