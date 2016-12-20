package com.alma.departements;

import com.alma.enseignants.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Departement{
	private String nom;
	private ArrayList<Parcours> parcours;
	private ArrayList<Enseignant> enseignants;
	
	public Departement(String nom){
		this.nom = nom;
		this.parcours = new ArrayList<Parcours>();
		this.enseignants = new ArrayList<Enseignant>();
	}
	
	public void ajouterDemande(Demande demande){
		
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
	
	public ArrayList<Enseignement> getEnseignements(){
		ArrayList<Enseignement> list = new ArrayList<Enseignement>();
		for(int i=0;i<this.parcours.size(); i++){
			ArrayList<Module> mod = this.parcours.get(i).getModules();
			for(int j=0;j<mod.size(); j++){
				list.add(mod.get(j).getEnseignement());
			}
		}
		return list;
	}
	
}
