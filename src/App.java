
import donnee.ExoplanetesDAO;
import donnee.ExoplanetesDAO2;
import vue.Fenetre;

public class App {

	public static void main(String[] parametres) {
		
		ExoplanetesDAO2 exoplaneteDAO = new ExoplanetesDAO2();
		exoplaneteDAO.listerExoplanetes();
		
		Fenetre.launch(Fenetre.class, parametres);	
	}

}
