/*
Sous Windows:
	Pour compiler,
	javac TestDataBase.java
	Pour exécuter,
	java -classpath ".;sqlite-jdbc-3.16.1.jar" TestDataBase
*/

import java.sql.*;

public class TestDataBase {
	public static void main(String[] args) {
		Connection connection = DBConnection.getDBConnection();
		Statement stmt = null;
		try{
			stmt = connection.createStatement();

			/* CREATE TABLE */

			/*
			String query = "CREATE TABLE COMPANY " +
						   "(ID INT PRIMARY KEY NOT NULL," +
						   " NAME TEXT NOT NULL, " +
						   " AGE INT NOT NULL, " +
						   " ADRESS CHAR(50), " +
						   " SALARY REAL)";

			stmt.executeUpdate(query);
			//*/

			/* INSERT */

			/*
			query = "INSERT INTO COMPANY (ID, NAME, AGE, ADRESS, SALARY) " +
						   "VALUES (1, 'Hamza', 4, 'Thies', 10000.00);";
			stmt.executeUpdate(query);

			query = "INSERT INTO COMPANY (ID, NAME, AGE, ADRESS, SALARY) " +
						   "VALUES (2, 'Amsa', 18, 'Touba', 20000.00);";
			stmt.executeUpdate(query);

			query = "INSERT INTO COMPANY (ID, NAME, AGE, ADRESS, SALARY) " +
						   "VALUES (3, 'Hamzatou', 28, 'Darou', 30000.00);";
			stmt.executeUpdate(query);

			query = "INSERT INTO COMPANY (ID, NAME, AGE, ADRESS, SALARY) " +
						   "VALUES (4, 'Amsatou', 27, 'Bordeaux', 40000.00);";
			stmt.executeUpdate(query);
			connection.commit();
			//*/

			/* UPDATE */

			/*
			String query = "UPDATE COMPANY SET SALARY = 50000.00 WHERE ID = 1";
			stmt.executeUpdate(query);
			connection.commit();
			//*/

			/* DELETE */

			/*
			String query = "DELETE FROM COMPANY WHERE ID = 5";
			stmt.executeUpdate(query);
			connection.commit();
			//*/



			/* SELECT */

			//*
			String table = "COMPANY";
			ResultSet result = stmt.executeQuery( "SELECT * FROM "+table+";" );
			while(result.next()){
				int id = result.getInt("id");
				String name = result.getString("name");
				int age = result.getInt("age");
				String adress = result.getString("adress");
				float salary = result.getFloat("salary");

				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);
				System.out.println("AGE = " + age);
				System.out.println("ADRESS = " + adress);
				System.out.println("SALARY = " + salary);
				System.out.println();
			}
			result.close();
			//*/

			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() +  ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Insertion effectu�e avec succ�s !");
	}
}
