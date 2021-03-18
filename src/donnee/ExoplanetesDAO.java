package donnee;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringBufferInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import modele.Exoplanete;

public class ExoplanetesDAO {

	public List<Exoplanete> listerExoplanetes()
	{
		String URL_SERVICE_DONNEES = "http://51.79.68.250/donnees/liste-planetes.php";
		String BALISE_EXOPLANETE = "exoplanete";
		String BALISE_FERMETURE = "</exoplanetes>";
		
		List<Exoplanete> listeExoplanetes =  new ArrayList<Exoplanete>();			
		Statement requeteListeExoplanetes;
		try {
			URL urlListeMeteore = new URL(URL_SERVICE_DONNEES);
			InputStream fluxURL = urlListeMeteore.openConnection().getInputStream();
			Scanner lecteur = new Scanner(fluxURL);
			
			lecteur.useDelimiter(BALISE_FERMETURE);
			String xml = lecteur.next() + BALISE_FERMETURE;
			
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = parseur.parse(new StringBufferInputStream(xml));
			
			NodeList noeuds = document.getElementsByTagName(BALISE_EXOPLANETE);
			
			for(int position = 0; position < noeuds.getLength(); position++)
			{
				Element noeud = (Element)noeuds.item(position);
				String planete = noeud.getElementsByTagName("planete").item(0).getTextContent();
				String etoile = noeud.getElementsByTagName("etoile").item(0).getTextContent();
				String masse = noeud.getElementsByTagName("masse").item(0).getTextContent();
				String rayon = noeud.getElementsByTagName("rayon").item(0).getTextContent();
				String flux = noeud.getElementsByTagName("flux").item(0).getTextContent();
				String temperature = noeud.getElementsByTagName("temperature").item(0).getTextContent();
				String periode = noeud.getElementsByTagName("periode").item(0).getTextContent();
				String distance = noeud.getElementsByTagName("distance").item(0).getTextContent();

				Exoplanete exoplanete = new Exoplanete();
				//exoplanete.setId(id);
				exoplanete.setNom(planete);
				exoplanete.setEtoile(etoile);
				exoplanete.setMasse(masse);
				exoplanete.setRayon(rayon);
				exoplanete.setFlux(flux);
				exoplanete.setTemperature(temperature);
				exoplanete.setPeriode(periode);
				exoplanete.setDistance(distance);
				
				listeExoplanetes.add(exoplanete);
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		return listeExoplanetes;
	}
	
	public void ajouterExoplanete(Exoplanete exoplanete) {
		
		String URL_AJOUTER_EXOPLANETE = "http://51.79.68.250/donnees/ajouter-exoplanete.php";
		
		String parametres = "planete=" + exoplanete.getNom() + "&etoile=" + exoplanete.getEtoile() + "&masse=" + exoplanete.getMasse()
		+ "&rayon=" + exoplanete.getRayon() + "&flux=" + exoplanete.getFlux() + "&temperature=" 
		+ exoplanete.getTemperature() + "&periode=" + exoplanete.getPeriode() + "&distance=" + exoplanete.getDistance();
		
		try {
			URL url = new URL(URL_AJOUTER_EXOPLANETE);
			HttpURLConnection connexion = (HttpURLConnection) url.openConnection();
			connexion.setDoOutput(true);
			connexion.setRequestMethod("POST");
			connexion.setFixedLengthStreamingMode(parametres.getBytes().length);
			connexion.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			OutputStream flux = connexion.getOutputStream();
			OutputStreamWriter messager = new OutputStreamWriter(flux);
			messager.write(parametres);
			messager.close();
			connexion.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modifierExoplanete(Exoplanete exoplanete, String initialPlanete) {
		
		String URL_MODIFIER_EXOPLANETE = "http://51.79.68.250/donnees/modifier-exoplanete.php";
		
		String parametres = "planete=" + exoplanete.getNom() + "&etoile=" + exoplanete.getEtoile()+ "&masse=" + exoplanete.getMasse()
		+ "&rayon=" + exoplanete.getRayon() + "&flux=" + exoplanete.getFlux() 
		+ "&temperature=" + exoplanete.getTemperature() + "&periode=" + exoplanete.getPeriode() 
		+ "&distance=" + exoplanete.getDistance() + "&initialPlanete=" + initialPlanete;

		try {
			URL url = new URL(URL_MODIFIER_EXOPLANETE);
			HttpURLConnection connexion = (HttpURLConnection) url.openConnection();
			connexion.setDoOutput(true);
			connexion.setRequestMethod("POST");
			connexion.setFixedLengthStreamingMode(parametres.getBytes().length);
			connexion.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			OutputStream flux = connexion.getOutputStream();
			OutputStreamWriter messager = new OutputStreamWriter(flux);
			messager.write(parametres);
			messager.close();
			connexion.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void supprimerExoplanete(Exoplanete exoplanete) {
		System.out.println("supprimer exoplanete");
		
		String URL_SUPPRIMER_EXOPLANETE = "http://51.79.68.250/donnees/supprimer-exoplanete.php";
		String parametres = "planete=" + exoplanete.getNom();
		try {
			URL url = new URL(URL_SUPPRIMER_EXOPLANETE);
			HttpURLConnection connexion = (HttpURLConnection) url.openConnection();
			connexion.setDoOutput(true);
			connexion.setRequestMethod("POST");
			connexion.setFixedLengthStreamingMode(parametres.getBytes().length);
			connexion.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			OutputStream flux = connexion.getOutputStream();
			OutputStreamWriter messager = new OutputStreamWriter(flux);
			messager.write(parametres);
			messager.close();
			connexion.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}