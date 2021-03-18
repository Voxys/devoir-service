package controleur;

import donnee.ExoplanetesDAO;
import modele.Exoplanete;
import vue.Navigateur;
import vue.Vue;
import vue.VueAjout;
import vue.VueExoplanetes;
import vue.VueModifier;

//import vue.Navigateur;
//import vue.*;

public class Controleur {
	
	public enum ActionNavigation {ACCUEIL, AJOUTER, MODIFIER};

	public static Vue selectionnerVuePrincipale()
	{
		ExoplanetesDAO exoplaneteDAO = new ExoplanetesDAO();
		VueExoplanetes.getInstance().afficherExoplanetes(exoplaneteDAO.listerExoplanetes());
		return VueExoplanetes.getInstance();
	}		
	
	public void navigation(ActionNavigation action) {

		switch(action)
		{
			case ACCUEIL:
				Navigateur.getInstance().afficherVue(VueExoplanetes.getInstance());
				break;
			case AJOUTER:
				Navigateur.getInstance().afficherVue(VueAjout.getInstance());
				break;
			case MODIFIER:
				Navigateur.getInstance().afficherVue(VueModifier.getInstance());
				VueModifier.getInstance().setTextFielSelectedExoplaneteValue();
				break;
			default:
				break;
		}	
	}
	
	public void rafraichirDonnees() {
		ExoplanetesDAO exoplaneteDAO = new ExoplanetesDAO();
		VueExoplanetes.getInstance().afficherExoplanetes(exoplaneteDAO.listerExoplanetes());
	}
}
