package dai_JDBC_PreparedStatementExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DQLExample {
	public static void main(String[] args){
		try(Connection conexion = DriverManager.getConnection(
			"jdbc:mysql://localhost/dai",
			"dai",
			"dai"
		)){
			try(PreparedStatement statement= conexion.prepareStatement(
				"SELECT * FROM Ejemplo "+
				"WHERE id > ?"
			)){
				statement.setInt(1,0);
				
				try(ResultSet result = statement.executeQuery()){
					while(result.next()){
						System.out.printf("Id:%d\nNombre:%s\n",result.getInt(1),result.getString(2));
					}
				}
			}
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
}
