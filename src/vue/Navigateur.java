package vue;

import com.sun.media.jfxmedia.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;
import modele.Exoplanete;

// Classe qui regroupe toutes les vues et permet de changer de page
public abstract class Navigateur extends Application{ // Application de javafx est en realite une fenetre
	
	protected Stage stade;
		
	private static Navigateur instance = null;
	public static Navigateur getInstance() {return instance;}	
	protected Navigateur()
	{
		instance = this;
		Logger.setLevel(Logger.INFO);
		VueExoplanetes.getInstance().activerControles();
		VueAjout.getInstance().activerControles();
		VueModifier.getInstance().activerControles();
	}
	
	public void afficherVue(Vue vue)
	{
		stade.setScene(vue);
		stade.show();				
	}
}
