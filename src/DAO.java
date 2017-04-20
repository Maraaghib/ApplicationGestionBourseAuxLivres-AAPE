import java.sql.*;

public abstract class DAO<T> {
	
	protected Connection connection = null;
	
	public DAO() {
		this.connection = DBConnection.getDBConnection();
	}
	
	/**
	* Méthode de création d'une table
	* @param obj
	* @return boolean 
	*/
	public abstract boolean createTable();
	
	/**
	* Méthode d'insertion dans une table
	* @param obj
	* @return boolean 
	*/
	public abstract boolean insert(T obj);
	
	/**
	* Méthode pour effacer un enregistrement via son ID
	* @param obj
	* @return boolean 
	*/
	public abstract boolean deleteById(T obj);
	
	/**
	* Méthode de mise à jour
	* @param obj
	* @return boolean
	*/
	public abstract boolean update(T obj);
	
	/**
	* Méthode de recherche des informations
	* @param id
	* @return T
	*/
	public abstract T selectById(int id);
	
}
