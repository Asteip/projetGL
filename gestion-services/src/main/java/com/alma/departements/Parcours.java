package com.alma.departements;

import java.util.ArrayList;

public class Parcours{

	private Departement departement;
	private ArrayList<Module> modules;
	private String nom;
	
	public Parcours(Departement departement, String nom) {
		this.departement = departement;
		this.modules = new ArrayList<Module>();
		this.nom = nom;
	}
	
	public Departement getDepartement() {
		return this.departement;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public ArrayList<Module> getModules() {
		return this.modules;
	}
	
	public void addModule(Module module) {
		modules.add(module);
	}
	
	public void deleteModule(Module module) {
		this.modules.remove(module);
	}
}
