package dai_JDBC_PreparedStatementExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			try(PreparedStatement statement = conexion.prepareStatement(
					"INSERT INTO Ejemplo (id,nombre)"+
					"VALUES (0,?),(0,?)",
					Statement.RETURN_GENERATED_KEYS
			)){
				statement.setString(1,"Pedro");
				statement.setString(2,"Dolores");
				
				int result = statement.executeUpdate();
				
				if(result == 2){
					try(ResultSet generatedKeys = statement.getGeneratedKeys()){
						while(generatedKeys.next()){
							System.out.println("Key"+generatedKeys.getInt(1));
						}
					}
				}else{
					throw new SQLException("Unexpected Value from result");
				}
			}
		}catch(SQLException e){
			System.err.println(e.getMessage());
		}
	}
}
