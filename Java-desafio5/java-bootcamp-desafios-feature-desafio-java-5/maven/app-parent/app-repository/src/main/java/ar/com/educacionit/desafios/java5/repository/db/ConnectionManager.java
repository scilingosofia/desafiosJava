package ar.com.educacionit.desafios.java5.repository.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	public static Connection getConnection() {
		String usernameDB = System.getenv("USERNAME");
		String passwordDB = System.getenv("PASSWORD");
		String url = "jdbc:mysql://127.0.0.1:33060/educacionit-bootcamp-vicente-lopez?allowPublicKeyRetrieval=true&serverTimeZone=UTC&useSSL=false";
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driverClassName);
			return DriverManager.getConnection(url, usernameDB, passwordDB);
		} catch(Exception e) {
			throw new IllegalArgumentException("No se pudo obtener conexion para: " +url +" - " + driverClassName, e);	
		}
	}
}
