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
		
		Button boutonAjout = (Button)lookup("#bouton-ajout");
		
		boutonAjout.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	controleur.ajouterExoplanete(lireExoplaneteEntre());
            }
        });
		
		Button boutonRetour = (Button)lookup("#bouton-retour");
		
		boutonRetour.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	controleur.navigation(ActionNavigation.ACCUEIL);
            	controleur.rafraichirDonnees();
            }
        });
	}

	public Exoplanete lireExoplaneteEntre()
	{
		Exoplanete exoplanete = new Exoplanete();
		
		TextField champsPlanete = (TextField) lookup("#textfield-planete");
		TextField champsEtoile = (TextField) lookup("#textfield-etoile");
		TextField champsMasse = (TextField) lookup("#textfield-masse");
		TextField champsRayon = (TextField) lookup("#textfield-rayon");
		TextField champsFlux = (TextField) lookup("#textfield-flux");
		TextField champsTemperature = (TextField) lookup("#textfield-temperature");
		TextField champsPeriode = (TextField) lookup("#textfield-periode");
		TextField champsDistance = (TextField) lookup("#textfield-distance");

		exoplanete.setNom(champsPlanete.getText());
		exoplanete.setEtoile(champsEtoile.getText());
		exoplanete.setMasse(champsMasse.getText());
		exoplanete.setRayon(champsRayon.getText());
		exoplanete.setFlux(champsFlux.getText());
		exoplanete.setTemperature(champsTemperature.getText());
		exoplanete.setPeriode(champsPeriode.getText());
		exoplanete.setDistance(champsDistance.getText());
		
		champsPlanete.setText("");
		champsEtoile.setText("");
		champsMasse.setText("");
		champsRayon.setText("");
		champsFlux.setText("");
		champsTemperature.setText("");
		champsPeriode.setText("");
		champsDistance.setText("");
		
		return exoplanete;
	}
}
