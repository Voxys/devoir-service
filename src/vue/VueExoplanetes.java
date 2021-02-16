package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.Controleur.ActionNavigation;
import donnee.ExoplanetesDAO2;
import controleur.ControleurExoplanetes;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	Label uiModifier = (Label)lookup("#ui-modifier");
	Label uiSupprimer = (Label)lookup("#ui-supprimer");
	
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
		
		Button boutonSupprimer = (Button)lookup("#bouton-supprimer");
		boutonSupprimer.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	ButtonClicked();
            }
        });
		
		
		
		tableau.setOnMouseClicked(event -> {
		    // Make sure the user clicked on a populated item
		    if (tableau.getSelectionModel().getSelectedItem() != null) {
		        uiModifier.setOpacity(1);
		        uiSupprimer.setOpacity(1);
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
	
		public void ButtonClicked()
		{
		  ObservableList<Exoplanete> row , allRows;
		  allRows = tableau.getItems();
		  row = tableau.getSelectionModel().getSelectedItems();   
		  System.out.println("ALLROWS:" + allRows + "ROW:"  + row);
		  row.forEach(allRows::remove);
		  uiModifier.setOpacity(0.35);
	      uiSupprimer.setOpacity(0.35);
		}
}
