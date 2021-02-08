
import donnee.ExoplanetesDAO;
import donnee.ExoplanetesDAO2;
import vue.Fenetre;

public class App {

	public static void main(String[] parametres) {
		
		ExoplanetesDAO2 etudiantDAO = new ExoplanetesDAO2();
		etudiantDAO.listerExoplanetes();
		
		Fenetre.launch(Fenetre.class, parametres);	
	}

}
