import java.io.File;
import java.io.IOException;
import java.sql.*;
import org.ini4j.*;

public class DBConnection {

		private String dbDriver = null;
		private String dbName = null;
		private static Connection connection;
		private Wini ini;
		
		

		// Constructeur privé
		private DBConnection(){
			try{
				/* Charger le fichier de configuration de la base de données */
				ini = new Wini(new File("database/config.ini"));
				/* Extraire les infos de la base de données */
				dbDriver = ini.get("dataBase", "dbDriver");
				dbName = ini.get("dataBase", "dbName");
			} 
			catch (InvalidFileFormatException e) {
				System.out.println("Format du fichier de configuration invalide !");
			}
			catch (IOException e) {
				System.out.println("Erreur de lecture du fichier de configuration !");
			}
			
			try{
				Class.forName(this.dbDriver);
				connection = DriverManager.getConnection(dbName);
				connection.setAutoCommit(false);
			} catch (Exception e) {
				System.err.println(e.getClass().getName() +  ": " + e.getMessage());
				System.exit(0);
			}
		}

		public static Connection getDBConnection(){
			if(connection == null){
				new DBConnection();
				System.out.println("Instance de la connexion SQL !");
			}
			else {
				System.out.println("Connexion SQL existante !");
			}

			return connection;
		}

}
