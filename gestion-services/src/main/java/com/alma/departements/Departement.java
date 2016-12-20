package com.alma.departements;

import com.alma.enseignants.*;

import java.util.ArrayList;
import java.util.Calendar;

public class Departement{
	private String nom;
	private ArrayList<Parcours> parcours;
	private ArrayList<Enseignant> enseignants;
	private enum typeL{valid, nonValid, affecter};
	
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
	
	
	public ArrayList<Demande> consulterDemande(typeL t){
		//affichage de la liste de demande
		//par deffault si c'est pas spécifié il retourne la liste de demande non validé
		switch (t) {
		case valid :  return valid; 
		case nonValid :   return nonValid;
		case affecter :  return affecter;
		default : return nonValid;
		}
	}
	

	public void validerDemande(Demande demande){
		nonValid.remove(demande);
		valid.add(demande);
	}
	
	public void affecterDemande(Demande demande){
		Intervention interv;
		
		// on créer une intervention correspondant aux differents souhaits (on garde l'id lors de la création
		// pour montrer que l'intervention correspond à un souhait)
		// de plus on creer un nouveau service si selui ci n'existe pas deja)
		

		Enseignant e = demande.getEnseignant();
		Service s = e.getCurrentService();
		
		int volume = 0;
		
		if (s.getAnnee() == Calendar.getInstance().get(Calendar.YEAR)){
			volume = s.getVolume();
		}
		
		if (demande instanceof Voeu) {
			interv = new InterventionDep(demande.getHeures(), new Service((volume + demande.getHeures()), Calendar.getInstance().get(Calendar.YEAR)) , demande.getId());
			s.addIntervention(interv);
		}
		else if (demande instanceof DemandeSpeciale) {
			interv = new CasSpecial(demande.getHeures(), new Service((volume + demande.getHeures()), Calendar.getInstance().get(Calendar.YEAR)), demande.getId());
			s.addIntervention(interv);
		}
		else if (demande instanceof DemandeInterExt) {
			interv = new InterventionExt(demande.getHeures(), new Service((volume + demande.getHeures()), Calendar.getInstance().get(Calendar.YEAR)), demande.getId());
			s.addIntervention(interv);
		}
		
		if(valid.contains(demande))
			valid.remove(demande);
		else
			nonValid.remove(demande);
		
		affecter.add(demande);
		
		
		
	}
	
	public void ImposeInterventionDepartement(Enseignant ens, Enseignement e, long id){
		
		Voeu voeu = new Voeu(1, ens, 1, e, id);
		affecterDemande(voeu);
		
	
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
