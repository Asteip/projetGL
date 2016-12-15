package com.alma.enseignants;

import java.util.ArrayList;
import java.util.List;

import com.alma.departements.Departement;
import com.alma.departements.Enseignement;
import com.alma.departements.Module;

public class Enseignant {

	private String nom;
	private String prenom;
	private String status;
	private List<Demande> souhaits;
	private List<Service> services;
	private Departement departement;
	private Contrat contrat;
	private long id;

	public Enseignant(String nom, String prenom, String status, Departement departement, Contrat contrat, long id){
		this.nom = nom;
		this.prenom = prenom;
		this.status = status;
		this.departement = departement;
		this.contrat = contrat;
		this.id = id;

		this.souhaits = new ArrayList<Demande>();
		this.services = new ArrayList<Service>();
	}

	public void creerVoeu(Module mod, Enseignement e, int volume, int priorite){
		Voeu v = new Voeu(volume, this, priorite, e);

		//utiliser v 
	}

	public void creerDemandeExterieur(String demande, int volume){
		DemandeInterExt d = new DemandeInterExt(volume, this, demande);
		//utilise d
	}

	public void creerDemandeSpeciale(String type, int volume){
		DemandeSpeciale d = new DemandeSpeciale(volume, this, type);
		//utiliser d
	}

	public List<Demande> consulterSouhait(boolean p){
		List<Demande> d = new ArrayList<Demande>();
		/*
		 * Pour toutes les demandes {
		 * if (demande.getPublie()){
		 * 	d.add(demande);
		 * }
		 * }
		 * return d;
		 * 
		 */
		return d;
	}

	public List<Enseignement> getEnseignements(){
		List<Enseignement> e = new ArrayList<Enseignement>();
		/*
		 * recherche tous les enseignements dans metier dpt
		 */
		return e;
	}


	//--- getters and setters ---

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Demande> getSouhaits() {
		return souhaits;
	}

	public void setSouhaits(List<Demande> souhaits) {
		this.souhaits = souhaits;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}