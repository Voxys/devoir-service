package vue;
import controleur.ControleurExoplanetes;
import controleur.Controleur.ActionNavigation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modele.Exoplanete;

public class VueModifier extends Vue {

	protected ControleurExoplanetes controleur;
	protected static VueModifier instance = null; 
	public static VueModifier getInstance() {if(null==instance)instance = new VueModifier(); return VueModifier.instance;}; 
	
	TextField champsPlanete = (TextField) lookup("#textfield-planete");
	TextField champsEtoile = (TextField) lookup("#textfield-etoile");
	TextField champsMasse = (TextField) lookup("#textfield-masse");
	TextField champsRayon = (TextField) lookup("#textfield-rayon");
	TextField champsFlux = (TextField) lookup("#textfield-flux");
	TextField champsTemperature = (TextField) lookup("#textfield-temperature");
	TextField champsPeriode = (TextField) lookup("#textfield-periode");
	TextField champsDistance = (TextField) lookup("#textfield-distance");
	
	Exoplanete selectedExoplanete;
		
	private VueModifier() 
	{
		super("exoplanete-modif.fxml"); 
		super.controleur = this.controleur = new ControleurExoplanetes();
//		
//		try {
//			System.out.println(controleur.getSelectedExoplanete() + " VUEMODIFIER");
//        	selectedExoplanete = controleur.getSelectedExoplanete();
//        	setTextFielSelectedExoplaneteValue();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
	}
		
	public void activerControles()
	{
		super.activerControles();
		System.out.println("test");
						
		Button boutonModifier = (Button)lookup("#bouton-modifier");
		
		boutonModifier.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	
            	// BESOIN DEXECUTER CETTE PARTIE ONLOAD //
        		
            	selectedExoplanete = controleur.getSelectedExoplanete();
            	controleur.modifierExoplanete(lireExoplaneteEntre(), selectedExoplanete.getNom()); //le nom initial de la planete me sert d'id pour le moment
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
	
	public void setTextFielSelectedExoplaneteValue() {
		champsPlanete.setText(selectedExoplanete.getNom());
		champsEtoile.setText(selectedExoplanete.getEtoile());
		champsMasse.setText(selectedExoplanete.getMasse());
	    champsRayon.setText(selectedExoplanete.getRayon());
		champsFlux.setText(selectedExoplanete.getFlux()); 
	    champsTemperature.setText(selectedExoplanete.getTemperature());
		champsPeriode.setText(selectedExoplanete.getPeriode());
	    champsDistance.setText(selectedExoplanete.getDistance());
	}
}
