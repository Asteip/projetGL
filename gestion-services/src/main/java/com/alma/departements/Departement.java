package com.alma.departements;

import com.alma.enseignants.*;

import java.util.ArrayList;
import java.util.Calendar;

public class Departement{
	private String nom;
	private ArrayList<Parcours> parcours;
	private ArrayList<Enseignant> enseignants;
	
	private ArrayList<Demande> nonValid;
	private ArrayList<Demande> valid;
	private ArrayList<Demande> affecter;
	
	public Departement(String nom){
		this.nom = nom;
		this.parcours = new ArrayList<Parcours>();
		this.enseignants = new ArrayList<Enseignant>();
	}
	
	public void ajouterDemande(Demande demande){
		nonValid.add(demande);
	}
	
	public void consulterDemande(){
		
	}
	
	public void validerDemande(Demande demande){
		nonValid.remove(demande);
		valid.add(demande);
	}
	
	public void affecterDemande(Demande demande){
		Intervention interv;
		
		// on créer une intervention correspondant aux differents souhaits (on garde l'id lors de la création
		// pour montrer que l'intervention correspond à un souhait)
		
		if (demande instanceof Voeu) {
			interv = new InterventionDep(demande.getHeures(), new Service(demande.getHeures(), Calendar.getInstance().get(Calendar.YEAR)), demande.getId());
		}
		else if (demande instanceof DemandeSpeciale) {
			interv = new CasSpecial(demande.getHeures(), new Service(demande.getHeures(), Calendar.getInstance().get(Calendar.YEAR)), demande.getId());
		}
		else if (demande instanceof DemandeInterExt) {
			interv = new InterventionExt(demande.getHeures(), new Service(demande.getHeures(), Calendar.getInstance().get(Calendar.YEAR)), demande.getId());
		}
		
		valid.remove(demande);
		affecter.add(demande);
		
		//travail sur la classe service.
		
		interv.getHeures
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

	public ArrayList<Demande> getNonValid() {
		return nonValid;
	}

	public void setNonValid(ArrayList<Demande> nonValid) {
		this.nonValid = nonValid;
	}

	public ArrayList<Demande> getValid() {
		return valid;
	}

	public void setValid(ArrayList<Demande> valid) {
		this.valid = valid;
	}
	
}
