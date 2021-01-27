package controleur;

import donnee.ExoplanetesDAO;
import vue.Vue;
import vue.VueExoplanetes;

//import vue.Navigateur;
//import vue.*;

public class Controleur {

	public static Vue selectionnerVuePrincipale()
	{
		ExoplanetesDAO etudiantDAO = new ExoplanetesDAO();
		VueExoplanetes.getInstance().afficherEtudiants(etudiantDAO.listerExoplanetes());
		return VueExoplanetes.getInstance();
	}		
}
