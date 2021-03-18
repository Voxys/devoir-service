package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.ExoplanetesDAO;
import modele.Exoplanete;
import vue.Vue;
import vue.VueExoplanetes;

public class ControleurExoplanetes extends Controleur{

	
	protected ExoplanetesDAO exoplanetesDAO;
	protected static Exoplanete selectedExoplanete;
	
	public ControleurExoplanetes()
	{
		Logger.logMsg(Logger.INFO, "new ControleurEcole()");
		this.exoplanetesDAO = new ExoplanetesDAO();
	}

	public void ajouterExoplanete(Exoplanete exoplanete) {
		this.exoplanetesDAO.ajouterExoplanete(exoplanete);
	}
	
	public void modifierExoplanete(Exoplanete exoplanete, String initialPlanete) {
		this.exoplanetesDAO.modifierExoplanete(exoplanete, initialPlanete);
	}
	
	public void supprimerExoplanete(Exoplanete exoplanete) {
		this.exoplanetesDAO.supprimerExoplanete(exoplanete);
	}
	
	public void setSelectedExoplanete(Exoplanete exoplanete) {
		this.selectedExoplanete = exoplanete;
		System.out.println(selectedExoplanete + " setSelectedExoplanete");
	}
	
	public Exoplanete getSelectedExoplanete() {
		System.out.println(selectedExoplanete + " getSelectedExoplanete");
		return this.selectedExoplanete;
	}
}
