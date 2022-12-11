// 3. Crie um DAO para cidades e crie um método de inserção de cidades.
// 4. Crie no seu DAO um método de remoção por DDD.

package exercicioJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cidadesDao {
	
	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
	private Connection conn;

	public cidadesDao() {
		this.conn = connectionFactoryCidades.getConnection();
	}
	
	public boolean insereCidade(cidadesPojo cidade) {
		String sql = "INSERT INTO cidades.cidades(ddd, nome, nro_habitantes, renda_per_capita, capital, estado, nome_prefeito)" 
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cidade.getDdd());
			stmt.setString(2, cidade.getNome());
			stmt.setInt(3, cidade.getNumeroHabitantes());
			stmt.setDouble(4, cidade.getRendaPerCapita());
			stmt.setBoolean(5, cidade.isCapital());
			stmt.setString(6, cidade.getEstado());
			stmt.setString(7, cidade.getNomePrefeito());
			stmt.execute();
			stmt.close();
			System.out.println(ANSI_YELLOW + "Cidade cadastrada com sucesso" + ANSI_RESET);
			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao enviar dados");
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public boolean removeCidade(int ddd) {
		String sql = "DELETE FROM cidades.cidades WHERE ddd = ?";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ddd);
			stmt.execute();
			stmt.close();
			System.out.println(ANSI_YELLOW + "Cidade removida com sucesso" + ANSI_RESET);
			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao apagar dados");
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public void listarCidades() {
		String sql = "select * from cidades.cidades";
		Map<Integer, cidadesPojo> cidadesSalvas = new HashMap<Integer, cidadesPojo>();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int ddd = rs.getInt("ddd");
				String nome = rs.getString("nome");
				int numeroHabitantes = rs.getInt("nro_habitantes");
				double rendaPerCapita = rs.getDouble("renda_per_capita");
				boolean capital = rs.getBoolean("capital");
				String estado = rs.getString("estado");
				String nomePrefeito = rs.getString("nome_prefeito");
				cidadesPojo cidadeSalva = new cidadesPojo(ddd, nome, numeroHabitantes, rendaPerCapita, capital, estado, nomePrefeito);
				cidadesSalvas.put(cidadeSalva.getDdd(), cidadeSalva);
			}
			for(cidadesPojo cidadeSalva : cidadesSalvas.values()) {
				System.out.println(ANSI_YELLOW + cidadeSalva + ANSI_RESET);
			}
		} catch(SQLException e) {
			System.err.println("Erro ao listar cidades cadastradas.");
		}
	}
	
	public void consultaCidadeDDD(int ddd) {
		String sql = "select * from cidades.cidades where ddd = ?";
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setInt(1, ddd);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				cidadesPojo cidadeConsulta = new cidadesPojo();
				cidadeConsulta.setDdd(rs.getInt("ddd"));
				cidadeConsulta.setNome(rs.getString("nome"));
				cidadeConsulta.setNumeroHabitantes(rs.getInt("nro_habitantes"));
				cidadeConsulta.setRendaPerCapita(rs.getDouble("renda_per_capita"));
				cidadeConsulta.setCapital(rs.getBoolean("capital"));
				cidadeConsulta.setEstado(rs.getString("estado"));
				cidadeConsulta.setNomePrefeito(rs.getString("nome_prefeito"));
				System.out.println(ANSI_YELLOW + cidadeConsulta + ANSI_RESET);
			}
		} catch (SQLException e) {
			System.err.println("Erro ao consultar cidade.");
		}
	}
	
	public void consultaCidadeInicio(String inicio) {
		String sql = "select * from cidades.cidades where nome like ?";
		List<cidadesPojo> cidadesConsultadas = new ArrayList<cidadesPojo>();
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, inicio + "%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				cidadesPojo cidadeConsultaNome = new cidadesPojo();
				cidadeConsultaNome.setDdd(rs.getInt("ddd"));
				cidadeConsultaNome.setNome(rs.getString("nome"));
				cidadeConsultaNome.setNumeroHabitantes(rs.getInt("nro_habitantes"));
				cidadeConsultaNome.setRendaPerCapita(rs.getDouble("renda_per_capita"));
				cidadeConsultaNome.setCapital(rs.getBoolean("capital"));
				cidadeConsultaNome.setEstado(rs.getString("estado"));
				cidadeConsultaNome.setNomePrefeito(rs.getString("nome_prefeito"));
				cidadesConsultadas.add(cidadeConsultaNome);
			}
			for(cidadesPojo cidadeConsultaNome : cidadesConsultadas) {
				System.out.println(ANSI_YELLOW + cidadeConsultaNome + ANSI_RESET);
			}
		} catch (SQLException e) {
			System.err.println("Erro ao listar cidades.");
		}
	}
	
}
