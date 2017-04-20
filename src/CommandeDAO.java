import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandeDAO extends DAO<Commande> {

	@Override
	public boolean createTable() {
		try{
			Statement stmt = connection.createStatement();
			
			String query = "CREATE TABLE IF NOT EXISTS commande " +
					   "(idCommande INTEGER PRIMARY KEY AUTOINCREMENT," +
					   " idAdherent INTEGER, "+
					   " idLivre INTEGER, "+
					   " dateCommande CHAR(255), "+
					   " prixCommande REAL) ";
			
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

	public boolean insert(Commande commande, Adherent adherent, int[] idLivre) { // Prendre commande seule en arg
	
		String query = "INSERT INTO commande (idAdherent, idLivre, dateCommande, prixCommande) "+
				"VALUES (?,?,?,?)";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			for (int i = 0; i < idLivre.length; i++) {
				pstmt.setLong(1, adherent.getIdAdherent());
				pstmt.setInt(2, idLivre[i]);
				pstmt.setString(3, commande.getDateCommande());
				pstmt.setDouble(4, adherent.getPrixCommande());
			   	
			   	// Enregistrer en même la commande concernant l'adhérent

				pstmt.executeUpdate();
			}
			connection.commit();
		} catch (SQLException e) {
			 e.printStackTrace();
//			return false;
		}

		return true;
	}

	@Override
	public boolean deleteById(Commande commande) {
	
		String query = "DELETE FROM commande WHERE idAdherent = ?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setLong(1, commande.getIdAdherent());

			pstmt.executeUpdate(query);
			connection.commit();
		} catch (SQLException e) {
			 e.printStackTrace();
//			return false;
		}
		
		return true;
	}

	public boolean update(Commande commande, Adherent adherent, int[] idLivre) {
	
		String query = "UPDATE commande SET "+
				"idLivre = ?, "+
				"dateCommande = ?, "+
				"prixCommande = ? "+
				"WHERE idAdherent = ?";
		try {
			for (int i = 0; i < idLivre.length; i++) {
				PreparedStatement pstmt = connection.prepareStatement(query);
				pstmt.setInt(1, idLivre[i]);
				pstmt.setString(2, commande.getDateCommande());
				pstmt.setDouble(3, adherent.getPrixCommande());
			   	pstmt.setLong(4, commande.getIdAdherent());

				pstmt.executeUpdate();
			}
			connection.commit();
		} catch (SQLException e) {
			 e.printStackTrace();
//			return false;
		}
		
		return true;
	}

	@Override
	public Commande selectById(int id) {
		Commande commande = new Commande();
		CommandeDAO comDAO = new CommandeDAO();
		ResultSet results;
		String query = "SELECT * FROM commande WHERE idAdherent = "+id+";";
		try {
			Statement stmt = connection.createStatement();
			results = stmt.executeQuery(query);
			
			int[] tabLivres = new int[100];
			int[] tabLivres2 = null;
			int i = 0;
			while(results.next()) {
				commande.setIdAdherent(id); // adherent.setIdAdherent(id);
				tabLivres[i] = results.getInt("idLivre");
				commande.setDateCommande(results.getString("dateCommande"));
				commande.setPrixCommande(results.getDouble("prixCommande"));
				i++;
			}	
			
			for (int j = 0; j < i; j++) {
				tabLivres2[j] = tabLivres[j];
			}
			
			commande.setIdLivre(tabLivres2);
			
			results.close();

		} catch (SQLException e) {
			 e.printStackTrace();
//			return null;
		}
		
		return commande;
	}

	@Override
	public boolean insert(Commande commande) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
