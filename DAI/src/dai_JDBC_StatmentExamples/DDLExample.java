package dai_JDBC_StatmentExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DDLExample {
	public static void main(String[] args){
		try(Connection conexion = DriverManager.getConnection(
				"jdbc:mysql://localhost/dai",
				"dai",
				"dai"
		)){
			try(Statement statement = conexion.createStatement()){
				int result = statement.executeUpdate(
					"CREATE TABLE Ejemplo("+
						"id INT NOT NULL AUTO_INCREMENT,"+
						"nombre VARCHAR(255) NOT NULL,"+
						"PRIMARY KEY (id)"+
					")"		
				);
				
				if(result != 0) throw new SQLException("Unexpected value from result");
				System.out.println("Table Ejemplo created on dai database");
			}
		}catch(SQLException e){
			System.err.println(e.getMessage());
		}
	}
}
