package vue;
import controleur.ControleurExoplanetes;
import controleur.Controleur.ActionNavigation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modele.Exoplanete;

public class VueAjout extends Vue {

	protected ControleurExoplanetes controleur;
	protected static VueAjout instance = null; 
	public static VueAjout getInstance() {if(null==instance)instance = new VueAjout();return VueAjout.instance;}; 
	
	private VueAjout() 
	{
		super("exoplanete-ajout.fxml"); 
		super.controleur = this.controleur = new ControleurExoplanetes();
	}
		
	public void activerControles()
	{
		super.activerControles();
		
		Button boutonRetour = (Button)lookup("#bouton-retour");
		
		boutonRetour.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	controleur.navigation(ActionNavigation.ACCUEIL);
            }
        });
	}

	public Exoplanete lireExoplaneteEntre()
	{
		Exoplanete etudiant = new Exoplanete();
		
		TextField champsPrenom = (TextField) lookup("#textfield-planete");
		TextField champsNom = (TextField) lookup("#textfield-etoile");
		
		etudiant.setNom(champsPrenom.getText());
		etudiant.setEtoile(champsNom.getText());
		
		champsPrenom.setText("");
		champsNom.setText("");
		
		return etudiant;
	}
}
