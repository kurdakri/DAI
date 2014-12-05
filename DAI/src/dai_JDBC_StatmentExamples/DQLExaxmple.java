package dai_JDBC_StatmentExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DQLExaxmple {
	public static void main(String[] args){
		try(Connection conexion = DriverManager.getConnection(
			"jdbc:mysql://localhost/dai",
			"dai",
			"dai"
		)){
		
			try(Statement statement = conexion.createStatement()){
				try(ResultSet result = statement.executeQuery(
					"SELECT * FROM Ejemplo"
				)){
					while(result.next()){
						System.out.printf("ID : %d \n Name: %s \n",result.getInt(1),result.getString(2));
					}
					
				}
			}
			
		}catch(SQLException e){
			System.err.println(e.getMessage());
		}
	}
}
