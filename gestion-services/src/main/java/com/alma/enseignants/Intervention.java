package com.alma.enseignants;

public abstract class Intervention {
	
	private int volume;
	private Service service;
	private int id;
	
	public Intervention (int volume, Service service, int id){
		this.volume = volume;
		this.service = service;
		this.id = id;
		//la création des interventions étant piloté par des demandes,
		//l'id des demandes est retranscrit à l'id des interventions pour garder une trace.
	}

	
	
	
	
	//--- getters and setters ---
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
