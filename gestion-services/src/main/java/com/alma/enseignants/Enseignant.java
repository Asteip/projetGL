package com.alma.enseignants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alma.departements.Departement;
import com.alma.departements.Enseignement;
import com.alma.departements.Module;

public class Enseignant {

	private String nom;
	private String prenom;
	private String status;
	private ArrayList<Demande> souhaits;
	private ArrayList<Service> services;
	private Service currentService;
	private ArrayList<Demande> valider;
	private Departement departement;
	private Contrat contrat;
	private long id;
	private ApplicationContext context;
	

	public Enseignant(String nom, String prenom, String status, Departement departement, Contrat contrat, long id){
		this.nom = nom;
		this.prenom = prenom;
		this.status = status;
		this.departement = departement;
		this.contrat = contrat;
		this.id = id;
		this.context = new ClassPathXmlApplicationContext("client-beans.xml");
		departement = (Departement) context.getBean("DemandeBean");
		
		this.souhaits = new ArrayList<Demande>();
		this.services = new ArrayList<Service>();
		
		currentService = new Service( 0, Calendar.getInstance().get(Calendar.YEAR));
		
		
		
	}

	public void creerVoeu(Module mod, Enseignement e, int volume, int priorite){
		long idvo = id + ((long)((Math.random() * 1000 )*0.00001));
		Voeu v = new Voeu(volume, this, priorite, e, idvo);
		souhaits.add(v);
	}

	public void creerDemandeExterieur(String demande, int volume){
		long idvo = id + ((long)((Math.random() * 1000 )*0.00001));
		DemandeInterExt d = new DemandeInterExt(volume, this, demande, idvo);
		souhaits.add(d);
	}

	public void creerDemandeSpeciale(String type, int volume){
		long idvo = id + ((long)((Math.random() * 1000 )*0.00001));
		DemandeSpeciale d = new DemandeSpeciale(volume, this, type, idvo);
		souhaits.add(d);
	}

	public ArrayList<Demande> consulterSouhait(boolean p){
		ArrayList<Demande> d = new ArrayList<Demande>();
		for (int i = 0; i < souhaits.size(); i++) {
			Demande s = souhaits.get(i);
			if(s.getPublie() == p){
				d.add(s);
			}
		}
		return d;
	}
	
	public ArrayList<Demande> consulterSouhait(int annee){
		ArrayList<Demande> d = new ArrayList<Demande>();
		ArrayList<Long> l = new ArrayList<Long>();
		
		for (int i = 0; i < services.size(); i++) {
			if (services.get(i).getAnnee() == annee) {
				ArrayList<Intervention> inte = services.get(i).getInterventions() ;
				for (int j = 0; j < inte.size(); j++) {
					l.add(inte.get(j).getId());
				}
			}
			else{
				
			}
		}
		for (int i = 0; i < l.size(); i++) {
			for (int j = 0; j < souhaits.size(); j++) {
				if(l.get(i) == souhaits.get(j).getId()){
					d.add(souhaits.get(j));
					j = souhaits.size(); //equivalent break
				}
			}
		}
		return d;
	}

	public ArrayList<Enseignement> getEnseignements(){
		ArrayList<Enseignement> e = new ArrayList<Enseignement>();
		e = departement.getEnseignements();
		return e;
	}

	public void publier(Demande demande){
		departement.ajouterDemande(demande);
		demande.setPublie(true);
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

	public ArrayList<Demande> getSouhaits() {
		return souhaits;
	}

	public void setSouhaits(ArrayList<Demande> souhaits) {
		this.souhaits = souhaits;
	}

	public ArrayList<Service> getServices() {
		return services;
	}

	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}
	
	public Service getCurrentService(){
		return currentService;
	}

	public void setCurrentService(Service serv){
		this.currentService = serv;
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

	public ArrayList<Demande> getValider() {
		return valider;
	}

	public void setValider(ArrayList<Demande> valider) {
		this.valider = valider;
	}
	
	public void addValider(ArrayList<Demande> v){
		ArrayList<Demande> dem = new ArrayList<Demande>();
		dem = departement.getValid();
		Demande d;
		for (int i = 0; i < souhaits.size(); i++) {
			d = souhaits.get(i);
			if(dem.contains(d)){
				if(valider.contains(d)){
					// no add necessary
				}
				else{
					valider.add(d);
				}
			}
		}
	}
	
	
}