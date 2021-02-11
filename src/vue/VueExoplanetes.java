package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.Controleur.ActionNavigation;
import donnee.ExoplanetesDAO2;
import controleur.ControleurExoplanetes;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Exoplanete;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class VueExoplanetes extends Vue{
	protected ControleurExoplanetes controleur;
	protected static VueExoplanetes instance = null; 
	public static VueExoplanetes getInstance() {if(null==instance)instance = new VueExoplanetes();return VueExoplanetes.instance;}; 
	
	TableView tableau = (TableView)lookup("#liste-exoplanetes");
	
	private VueExoplanetes() 
	{
		super("exoplanetes.fxml"); 
		super.controleur = this.controleur = new ControleurExoplanetes();
		Logger.logMsg(Logger.INFO, "new VueExoplanetes()");
	}
		
	public void activerControles()
	{
		super.activerControles();
		
		ExoplanetesDAO2 exoplaneteDAO = new ExoplanetesDAO2();
		
		Button boutonActualiser = (Button)lookup("#bouton-actualiser");
		
		boutonActualiser.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	controleur.rafraichirDonnees();
            }
        });

		Button boutonAjouter = (Button)lookup("#bouton-ajouter");
		
		boutonAjouter.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	controleur.navigation(ActionNavigation.AJOUTER);
            }
        });
	}
	
	public void afficherEtudiants(List<Exoplanete> exoplanetes)
	{	
		//Nettoyage des possibles données précédentes
		tableau.getItems().clear();
		
		// Association des champs de l'objet avec les colonnes du tableau		
		TableColumn colonneNom = (TableColumn) tableau.getColumns().get(0);
		TableColumn colonneEtoile = (TableColumn) tableau.getColumns().get(1);
		TableColumn colonneMasse = (TableColumn) tableau.getColumns().get(2);
		TableColumn colonneRayon = (TableColumn) tableau.getColumns().get(3);
		TableColumn colonneFlux = (TableColumn) tableau.getColumns().get(4);
		TableColumn colonneTemperature = (TableColumn) tableau.getColumns().get(5);
		TableColumn colonnePeriode = (TableColumn) tableau.getColumns().get(6);
		TableColumn colonneDistance = (TableColumn) tableau.getColumns().get(7);
		
		colonneNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		colonneEtoile.setCellValueFactory(new PropertyValueFactory<>("etoile"));
		colonneMasse.setCellValueFactory(new PropertyValueFactory<>("masse"));
		colonneRayon.setCellValueFactory(new PropertyValueFactory<>("rayon"));
		colonneFlux.setCellValueFactory(new PropertyValueFactory<>("flux"));
		colonneTemperature.setCellValueFactory(new PropertyValueFactory<>("temperature"));
		colonnePeriode.setCellValueFactory(new PropertyValueFactory<>("periode"));
		colonneDistance.setCellValueFactory(new PropertyValueFactory<>("distance"));
		
		// Ajout des donnees
		for(Exoplanete exoplanete : exoplanetes)
		{ 
			System.out.println(exoplanete.getNom());
			tableau.getItems().add(exoplanete);
		}
	 }
}
