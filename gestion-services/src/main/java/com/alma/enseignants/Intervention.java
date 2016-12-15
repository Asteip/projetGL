package com.alma.enseignants;

public abstract class Intervention {
	
	private int volume;
	private Service service;
	
	public Intervention (int volume, Service service){
		this.volume = volume;
		this.service = service;
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
	
	
}
