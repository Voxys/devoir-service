
import donnee.ExoplanetesDAO;
import vue.Fenetre;

public class App {

	public static void main(String[] parametres) {
		
		ExoplanetesDAO etudiantDAO = new ExoplanetesDAO();
		etudiantDAO.listerExoplanetes();
		
		Fenetre.launch(Fenetre.class, parametres);	
	}

}
