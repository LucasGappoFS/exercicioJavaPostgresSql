// 1. Construa sua fábrica de conexões e estabeleça conexão com o banco de dados mildevs,
// teste essa conexão utilizando um programa principal.

package exercicioJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionFactoryCidades {
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/mildevs", "postgres", "pgadmin");
		} catch(SQLException e) {
			System.err.println("Erro ao estabelecer conexão");
			System.err.println(e.getMessage());
			return null;
		}
	}
}
