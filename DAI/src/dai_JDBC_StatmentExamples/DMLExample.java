package dai_JDBC_StatmentExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DMLExample {
	public static void main(String[] args){
		try(Connection conexion = DriverManager.getConnection(
			"jdbc:mysql://localhost/dai",
			"dai",
			"dai"
		)){
			try(Statement statement = conexion.createStatement()){
				int result = statement.executeUpdate(
					"INSERT INTO Ejemplo (id,nombre)"+
					"VALUES (0,'Ana'),(0,'Juan')",
					Statement.RETURN_GENERATED_KEYS
				);
				
				if(result == 2){
					System.out.println("Insert done.\n");
					//Obtenemos las  claves autogeneradas
					try(ResultSet generatedKeys = statement.getGeneratedKeys()){
						while(generatedKeys.next()){
							System.out.println("Key:"+generatedKeys.getInt(1));
						}
					}
				}else{
					throw new SQLException("Unexpected value from result");
				}
			}
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
}
