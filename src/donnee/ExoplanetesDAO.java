package donnee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Exoplanete;

public class ExoplanetesDAO {

	public List<Exoplanete> listerExoplanetes()
	{
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		
		List<Exoplanete> listeEtudiants =  new ArrayList<Exoplanete>();			
		Statement requeteListeExoplanetes;
		try {
			requeteListeExoplanetes = connection.createStatement();
			ResultSet curseurListeEtudiants = requeteListeExoplanetes.executeQuery("SELECT * from exoplanete");
			while(curseurListeEtudiants.next())
			{
				//int id = curseurListeEtudiants.getInt("id");
				String nom = curseurListeEtudiants.getString("planete");
				String etoile = curseurListeEtudiants.getString("etoile");
				String masse = curseurListeEtudiants.getString("masse");
				String rayon = curseurListeEtudiants.getString("rayon");
				String flux = curseurListeEtudiants.getString("flux");
				String temperature = curseurListeEtudiants.getString("temperature");
				String periode = curseurListeEtudiants.getString("periode");
				String distance = curseurListeEtudiants.getString("distance");
				
				Exoplanete exoplanete = new Exoplanete();
				//exoplanete.setId(id);
				exoplanete.setNom(nom);
				exoplanete.setEtoile(etoile);
				exoplanete.setMasse(masse);
				exoplanete.setRayon(rayon);
				exoplanete.setFlux(flux);
				exoplanete.setTemperature(temperature);
				exoplanete.setPeriode(periode);
				exoplanete.setDistance(distance);
				
				listeEtudiants.add(exoplanete);
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		return listeEtudiants;
	}
}