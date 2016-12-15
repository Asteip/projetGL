package enseignants;
public abstract class Demande {

	private boolean publiee;
	private int heures;
	private Enseignant enseignant;

	public boolean getPubliee(){
		return this.publiee;
	}

	public int getHeures() {
		return this.heures;
	}

	public Enseignant getEnseignant() {
		return this.enseignant;
	}
} 