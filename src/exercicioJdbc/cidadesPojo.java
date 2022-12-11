// 2. Represente a tabela cidade(ddd*, nome, nro_habitantes, renda_per_capita, capital**,
// estado, nome_prefeito) com um POJO.
// *PK
// **capital é um booleano.

package exercicioJdbc;

public class cidadesPojo {
	
	private int ddd;
	private String nome;
	private int numeroHabitantes;
	private double rendaPerCapita;
	private boolean capital;
	private String estado;
	private String nomePrefeito;
	
	public cidadesPojo(int ddd, String nome, int numeroHabitantes, double rendaPerCapita, boolean capital,
			String estado, String nomePrefeito) {
		this.ddd = ddd;
		this.nome = nome;
		this.numeroHabitantes = numeroHabitantes;
		this.rendaPerCapita = rendaPerCapita;
		this.capital = capital;
		this.estado = estado;
		this.nomePrefeito = nomePrefeito;
	}
	
	public cidadesPojo() {
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(int numeroHabitantes) {
		this.numeroHabitantes = numeroHabitantes;
	}

	public double getRendaPerCapita() {
		return rendaPerCapita;
	}

	public void setRendaPerCapita(double rendaPerCapita) {
		this.rendaPerCapita = rendaPerCapita;
	}

	public boolean isCapital() {
		return capital;
	}

	public void setCapital(boolean capital) {
		this.capital = capital;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNomePrefeito() {
		return nomePrefeito;
	}

	public void setNomePrefeito(String nomePrefeito) {
		this.nomePrefeito = nomePrefeito;
	}

	@Override
	public String toString() {
		return "[DDD: " + ddd + ", Nome: " + nome + ", Número de Habitantes: " + numeroHabitantes
				+ ", Renda Per Capita: " + rendaPerCapita + ", Capital: " + capital + ", Estado: " + estado
				+ ", Nome do Prefeito: " + nomePrefeito + "]";
	}

}
