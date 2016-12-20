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
	
	public ArrayList<Parcours> getParcours() {
		return parcours;
	}

	public void setParcours(ArrayList<Parcours> parcours) {
		this.parcours = parcours;
	}

	public ArrayList<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(ArrayList<Enseignant> enseignants) {
		this.enseignants = enseignants;
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
	
	public void addEnseignant(Enseignant enseignant) {
		this.enseignants.add(enseignant);
	}
	public void addParcours(Parcours p) {
		this.parcours.add(p);
	}
	public void removeEnseignant(Enseignant enseignant){
		this.enseignants.remove(enseignant);
	}
	public void removeParcours(Parcours parcours){
		this.parcours.remove(parcours);
	}
}
