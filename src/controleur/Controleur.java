package controleur;

import donnee.ExoplanetesDAO;
import donnee.ExoplanetesDAO2;
import vue.Vue;
import vue.VueExoplanetes;

//import vue.Navigateur;
//import vue.*;

public class Controleur {

	public static Vue selectionnerVuePrincipale()
	{
		ExoplanetesDAO2 etudiantDAO = new ExoplanetesDAO2();
		VueExoplanetes.getInstance().afficherEtudiants(etudiantDAO.listerExoplanetes());
		return VueExoplanetes.getInstance();
	}		
}
