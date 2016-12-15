package com.alma.departements;

public class TypeEnseignement {
	
	public static final int CM = 1;
	public static final int TD = 2;
	public static final int TP = 3;
	
	/**
	 * Converti un entier en une chaîne de caractère correspondant à un type d'enseignement. 
	 * @param type Un entier supposé correspondre à une des constantes de TypeEnseignement.
	 * @return En fonction de l'entier passé en paramètre : CM / TD / TP.
	 * @throws Exception Lorsque l'entier en paramètre est inconnu.
	 */
	public static String getType(int type) throws Exception {
		String ret = "";
		
		if (type == CM) {
			ret = "CM";
		}
		else if(type == TD) {
			ret = "TD";
		}
		else if(type == TP) {
			ret = "TP";
		}
		else {
			throw new Exception("Type d'enseignement non reconnu. \\"
					+ "Veuillez utiliser les constantes définies dans la classe TypeEnseignement pour construire un objet Enseignement");
		}
		
		return ret;
	}
}
