package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.ExoplanetesDAO;
import donnee.ExoplanetesDAO2;
import modele.Exoplanete;
import vue.Vue;
import vue.VueExoplanetes;

public class ControleurExoplanetes extends Controleur{

	
	protected ExoplanetesDAO2 exoplanetesDAO;
	public ControleurExoplanetes()
	{
		Logger.logMsg(Logger.INFO, "new ControleurEcole()");
		this.exoplanetesDAO = new ExoplanetesDAO2();
	}

	public void ajouterExoplanete(Exoplanete exoplanete) {
		this.exoplanetesDAO.ajouterExoplanete(exoplanete);
	}
}
