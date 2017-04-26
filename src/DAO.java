import java.sql.*;

public abstract class DAO<T> {
	
	protected Connection connection = null;
	
	public DAO() {
		this.connection = DBConnection.getDBConnection();
	}
	
	/**
	* M�thode de cr�ation d'une table
	* @param obj
	* @return boolean 
	*/
	public abstract boolean createTable();
	
	/**
	* M�thode d'insertion dans une table
	* @param obj
	* @return boolean 
	*/
	public abstract boolean insert(T obj);
	
	/**
	* M�thode pour effacer un enregistrement via son ID
	* @param obj
	* @return boolean 
	*/
	public abstract boolean deleteById(T obj);
	
	/**
	* M�thode de mise � jour
	* @param obj
	* @return boolean
	*/
	public abstract boolean update(T obj);
	
	/**
	* M�thode de recherche des informations
	* @param id
	* @return T
	*/
	public abstract T selectById(long id);
	
}
