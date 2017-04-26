import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LivreDAO extends DAO<Livre> {

	@Override
	public boolean createTable() {
		try{
			Statement stmt = connection.createStatement();
			
			String query = "CREATE TABLE IF NOT EXISTS livre " +
					   "(idLivre INTEGER PRIMARY KEY AUTOINCREMENT," +
					   " designation CHAR(255), "+
					   " prix REAL, "+
					   " etat INTEGER, "+
					   " reference INTEGER, "+
					   " enStock INTEGER) "; //0 ou 1
			
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
	public boolean insert(Livre livre) {
	
		String query = "INSERT INTO livre (idLivre, designation, prix, etat, reference, enStock) "+
				"VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setLong(1, livre.getIdLivre());
			pstmt.setString(2, livre.getDesignation());
			pstmt.setDouble(3, livre.getPrix());
			pstmt.setInt(4, livre.getEtat());
			pstmt.setLong(5, livre.getReference());
			pstmt.setByte(6, livre.isEnStock());
		   	
		   	// Enregistrer en m�me la commande concernant l'adh�rent

			pstmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			 e.printStackTrace();
//			return false;
		}

		return true;
	}

	@Override
	public boolean deleteById(Livre livre) {
	
		String query = "DELETE FROM livre WHERE idLivre = ?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setLong(1, livre.getIdLivre());

			pstmt.executeUpdate(query);
			connection.commit();
		} catch (SQLException e) {
			 e.printStackTrace();
//			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Livre livre) {
	
		String query = "UPDATE livre SET "+
				"idLivre = ?, "+
				"designation = ?, "+
				"prix = ?, "+
				"etat = ? ,"+
				"reference = ?, "+
				"enStock = ? "+
				"WHERE idLivre = ?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setLong(1, livre.getIdLivre());
			pstmt.setString(2, livre.getDesignation());
			pstmt.setDouble(3, livre.getPrix());
			pstmt.setInt(4, livre.getEtat());
			pstmt.setLong(5, livre.getReference());
			pstmt.setByte(6, livre.isEnStock());
			pstmt.setLong(7, livre.getIdLivre());

			pstmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			 e.printStackTrace();
//			return false;
		}
		
		return true;
	}

	@Override
	public Livre selectById(long id) {
		Livre livre = new Livre();
		ResultSet results;
		String query = "SELECT * FROM livre WHERE idLivre = "+id+";";
		try {
			Statement stmt = connection.createStatement();
			results = stmt.executeQuery(query);
			
			if(results.next()) {
				livre.setIdLivre(id); // adherent.setIdAdherent(id);
				livre.setDesignation(results.getString("designation"));
				livre.setPrix(results.getDouble("prix"));
				livre.setEtat(results.getInt("etat"));
				livre.setReference(results.getInt("reference"));
				livre.setEnStock(results.getByte("enStock"));
			}	
			
			results.close();

		} catch (SQLException e) {
			 e.printStackTrace();
//			return null;
		}
		
		return livre;
	}

	public ArrayList<Livre> selectAll() {
		
		ArrayList<Livre> listLivres = new ArrayList<Livre>();
		ResultSet results;
		String query = "SELECT * FROM livre;";
		try {
			Statement stmt = connection.createStatement();
			results = stmt.executeQuery(query);
			
			while(results.next()) {
				Livre livre = new Livre();
				livre.setIdLivre(results.getLong("idLivre")); // adherent.setIdAdherent(id);
				livre.setDesignation(results.getString("designation"));
				livre.setPrix(results.getDouble("prix"));
				livre.setEtat(results.getInt("etat"));
				livre.setReference(results.getInt("reference"));
				livre.setEnStock(results.getByte("enStock"));
				
				listLivres.add(livre);
			}	
			
			results.close();

		} catch (SQLException e) {
			 e.printStackTrace();
//			return null;
		}
		
		return listLivres;
	}

}
