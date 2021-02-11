package controleur;

import donnee.ExoplanetesDAO;
import donnee.ExoplanetesDAO2;
import vue.Navigateur;
import vue.Vue;
import vue.VueAjout;
import vue.VueExoplanetes;

//import vue.Navigateur;
//import vue.*;

public class Controleur {
	
	public enum ActionNavigation {ACCUEIL, AJOUTER, EDITER};

	public static Vue selectionnerVuePrincipale()
	{
		ExoplanetesDAO2 exoplaneteDAO = new ExoplanetesDAO2();
		VueExoplanetes.getInstance().afficherEtudiants(exoplaneteDAO.listerExoplanetes());
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
//			case EDITER:
////				Navigateur.getInstance().afficherVue(VueSalonJeuxVideo.getInstance());
//				break;
			default:
				break;
		}	
	}
}
