package donnee;

import java.io.InputStream;
import java.io.StringBufferInputStream;
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

public class ExoplanetesDAO2 {

	public List<Exoplanete> listerExoplanetes()
	{
		String URL_SERVICE_DONNEES = "http://51.79.68.250/donnees/liste-planetes.php";
		String BALISE_EXOPLANETE = "exoplanete";
		String BALISE_FERMETURE = "</exoplanetes>";
		
		List<Exoplanete> listeEtudiants =  new ArrayList<Exoplanete>();			
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
				
				listeEtudiants.add(exoplanete);
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		return listeEtudiants;
	}
}