import java.sql.*;
import java.util.Calendar;

public class AdherentDAO extends DAO<Adherent> {
	
//	private long id;
//	
//	public boolean initId() {
//		try{
//			Statement stmt = connection.createStatement();
//			
//			String query = "CREATE TABLE IF NOT EXISTS identifiant " +
//					   "(pk INTEGER PRIMARY KEY AUTOINCREMENT," +
//					   " id INTEGER) "; // La table contenant les id des adhérents initialisée à YYYY0
//			
//			stmt.executeUpdate(query);
//
//			stmt.close();
////			connection.close();
//		} catch (Exception e) {
//			System.err.println(e.getClass().getName() +  ": " + e.getMessage());
//			System.exit(0);
////			return false;
//		}
//		
//		return true;
//	}
	
	// Retourne un nouvel identifiant pour un adhérent sous la forme YYYYX (où YYYY est l'année courante et X en entier qu'on incrémente à chaquel nouvel adhérent
	public void newId() {
//		ResultSet results;
////		long id = -1;
//		String query = "SELECT * FROM identifiant;";
//		try {
//			Statement stmt = connection.createStatement();
//			results = stmt.executeQuery(query);
//			
//			if(results.next()) {
//				this.id = results.getLong("id");
//			}	
//			
//			results.close();
//
//		} catch (SQLException e) {
//			 e.printStackTrace();
////			return -1;
//		}
//		
////		return id;
	}
	
//	public long getId() {
//		return this.id;
//	}
	
	// Mettre à jour l'identifiant du dernier adhérent 
	public boolean updateId() {
	
		String query = "UPDATE identifiant SET "+
				"id = ?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setLong(1, 20170);

			pstmt.executeUpdate(); // Enlever query
			connection.commit();
		} catch (SQLException e) {
			 e.printStackTrace();
//			return false;
		}
		
		return true;
	}

	@Override
	public boolean createTable() {
		try{
			Statement stmt = connection.createStatement();
			
			String query = "CREATE TABLE IF NOT EXISTS adherent " +
					   "(idAdherent INTEGER PRIMARY KEY," +
					   " prenom CHAR(255) NOT NULL, "+
					   " nom CHAR(255) NOT NULL, "+
					   " dateNaiss CHAR(255) NOT NULL, "+
					   " telPerso CHAR(255) NOT NULL, "+
					   " mailPerso CHAR(255), "+
					   " classe CHAR(255) NOT NULL, "+
					   " specialite CHAR(255), "+
					   " nomParaent CHAR(255) NOT NULL, "+
					   " prenomParent CHAR(255) NOT NULL, "+
					   " respLegal CHAR(255), "+
					   " adresse CHAR(255) NOT NULL, "+
					   " codePostal INT NOT NULL, "+
					   " ville CHAR(255) NOT NULL, "+
					   " telParent CHAR(255) NOT NULL, "+
					   " participation CHAR(255) NOT NULL, "+
					   " formule CHAR(255) NOT NULL, "+
					   " acompte REAL, "+
					   " montant REAL NOT NULL, "+
					   " typeLivre CHAR(255) NOT NULL, "+
					   " dateAdhesion CHAR(255) NOT NULL) ";
			
			stmt.executeUpdate(query);

			stmt.close();
//			connection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() +  ": " + e.getMessage());
			System.exit(0);
//			return false;
		}
		
		return true;
	}

	@Override
	public boolean insert(Adherent adherent) {
	
		String query = "INSERT INTO adherent (idAdherent, prenom, nom, dateNaiss, telPerso, mailPerso, classe, specialite, nomParaent, prenomParent, respLegal, adresse, codePostal, ville, telParent, participation, formule, acompte, montant, typeLivre, dateAdhesion) "+
				"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setLong(1, adherent.getIdAdherent());
			pstmt.setString(2, adherent.getPrenom());
			pstmt.setString(3, adherent.getNom());
			pstmt.setString(4, adherent.getDateNaiss());
			pstmt.setString(5, adherent.getTelPerso());
			pstmt.setString(6, adherent.getMailPerso());
			pstmt.setString(7, adherent.getClasse());
			pstmt.setString(8, adherent.getSpecialite());
			pstmt.setString(9, adherent.getNomParaent());
			pstmt.setString(10, adherent.getPrenomParent());
			pstmt.setString(11, adherent.getRespLegal());
			pstmt.setString(12, adherent.getAdresse());
			pstmt.setDouble(13, adherent.getCodePostal());
			pstmt.setString(14, adherent.getVille());
			pstmt.setString(15, adherent.getTelParent());
			pstmt.setString(16, adherent.getParticipation());
			pstmt.setString(17, adherent.getFormule());
			pstmt.setDouble(18, adherent.getAcompte());
			pstmt.setDouble(19, adherent.getMontant());
			pstmt.setString(20, adherent.getTypeLivre());
			pstmt.setString(21, adherent.getDateAdhesion());

			pstmt.executeUpdate();
			connection.commit();
			
//			updateId();
		} catch (SQLException e) {
			 e.printStackTrace();
//			return false;
		}
		
	   	
//	   	Commade commande = new Commande(adherent.getTypeLivre(), )
	   	
//		ON ENREGISTRE UNIQUEMENT LES ID DES LIVRES DANS LA TABLES DES COMMANDES
	   	
		CommandeDAO comDAO = new CommandeDAO();
//		for (int i = 0; i < adherent.getListeLivre().length; i++) {
			comDAO.insert(adherent.getCommande(), adherent, adherent.getListeLivre());
//		}
		
	   	
	   	// Enregistrer en même la commande concernant l'adhérent

		return true;
	}

	@Override
	public boolean deleteById(Adherent adherent) {
	
		String query = "DELETE FROM adherent WHERE idAdherent = ?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setLong(1, adherent.getIdAdherent());

			pstmt.executeUpdate(query);
			connection.commit();
		} catch (SQLException e) {
			 e.printStackTrace();
//			return false;
		}
		
//		supprimer aussi LA commande et les livres
		
		return true;
	}

	@Override
	public boolean update(Adherent adherent) {
	
		String query = "UPDATE adherent SET "+
				"prenom = ?, "+
				"nom = ?, "+
				"dateNaiss = ?, "+
				"telPerso = ?, "+
				"mailPerso = ?, "+
				"classe = ?, "+
				"specialite = ?, "+
				"nomParaent = ?, "+
				"prenomParent = ?, "+
				"respLegal = ?, "+
				"adresse = ?, "+
				"codePostal = ?, "+
				"ville = ?, "+
				"telParent = ?, "+
				"participation = ?, "+
				"formule = ?, "+
				"acompte = ?, "+
				"montant = ?, "+
				"typeLivre = ?, "+
				"dateAdhesion = ? "+
				"WHERE idAdherent = ?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, adherent.getPrenom());
			pstmt.setString(2, adherent.getNom());
			pstmt.setString(3, adherent.getDateNaiss());
			pstmt.setString(4, adherent.getTelPerso());
			pstmt.setString(5, adherent.getMailPerso());
			pstmt.setString(6, adherent.getClasse());
			pstmt.setString(7, adherent.getSpecialite());
			pstmt.setString(8, adherent.getNomParaent());
			pstmt.setString(9, adherent.getPrenomParent());
			pstmt.setString(10, adherent.getRespLegal());
			pstmt.setString(11, adherent.getAdresse());
			pstmt.setDouble(12, adherent.getCodePostal());
			pstmt.setString(13, adherent.getVille());
			pstmt.setString(14, adherent.getTelParent());
			pstmt.setString(15, adherent.getParticipation());
			pstmt.setString(16, adherent.getFormule());
			pstmt.setDouble(17, adherent.getAcompte());
			pstmt.setDouble(18, adherent.getMontant());
			pstmt.setString(19, adherent.getTypeLivre());
		   	pstmt.setString(20, adherent.getDateAdhesion());
		   	pstmt.setLong(21, adherent.getIdAdherent());

			pstmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			 e.printStackTrace();
//			return false;
		}
		
		return true;
	}

	@Override
	public Adherent selectById(int id) {
		// Essayer INNER JOIN pour récupérer les commandes. ??
		Adherent adherent = new Adherent();
		CommandeDAO comDAO = new CommandeDAO();
		ResultSet results;
		String query = "SELECT * FROM adherent INNER JOIN commande ON adherent.idAdherent = "+id+";";
		try {
			Statement stmt = connection.createStatement();
			results = stmt.executeQuery(query);
			
			if(results.next()) {
				adherent.setIdAdherent(id); // adherent.setIdAdherent(id);
				adherent.setPrenom(results.getString("prenom"));
				adherent.setNom(results.getString("nom"));
				adherent.setDateNaiss(results.getString("dateNaiss"));
				adherent.setTelPerso(results.getString("telPerso"));
				adherent.setMailPerso(results.getString("mailPerso"));
				adherent.setClasse(results.getString("classe"));
				adherent.setSpecialite(results.getString("specialite"));
				adherent.setNomParaent(results.getString("nomParaent"));
				adherent.setPrenomParent(results.getString("prenomParent"));
				adherent.setRespLegal(results.getString("respLegal"));
				adherent.setAdresse(results.getString("adresse"));
				adherent.setCodePostal(results.getLong("codePostal"));
				adherent.setVille(results.getString("ville"));
				adherent.setTelParent(results.getString("telParent"));
				adherent.setParticipation(results.getString("participation"));
				adherent.setFormule(results.getString("formule"));
				adherent.setAcompte(results.getDouble("acompte"));
				adherent.setMontant(results.getDouble("montant"));
				adherent.setTypeLivre(results.getString("typeLivre"));
				adherent.setDateAdhesion(results.getString("dateAdhesion"));
				
				adherent.setCommande(comDAO.selectById(id));
				
			}	
			
//			LivreDAO livreDAO = new LivreDAO();
//			
//			results.beforeFirst();
//			while (results.next()) {
//				adherent.addLivre(livreDAO.selectById(results.getInt("idLivre")));
//			}

			results.close();

		} catch (SQLException e) {
			 e.printStackTrace();
//			return null;
		}
		
		return adherent;
	}

}
