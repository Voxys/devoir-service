
import donnee.ExoplanetesDAO;
import vue.Fenetre;

public class App {

	public static void main(String[] parametres) {
		ExoplanetesDAO exoplaneteDAO = new ExoplanetesDAO();
		exoplaneteDAO.listerExoplanetes();
		Fenetre.launch(Fenetre.class, parametres);	
	}

}
