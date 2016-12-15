package com.alma.enseignants;

public abstract class Intervention {
	
	private String volume;
	private Service service;
	
	public Intervention (String volume, Service service){
		this.volume = volume;
		this.service = service;
	}

	
	//--- getters and setters ---
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}

	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
	
}
