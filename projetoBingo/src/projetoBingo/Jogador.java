package projetoBingo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Jogador {

	private String email;
	private String senha;
	private String dataMes;
	private String vitorias;

	public Jogador(ResultSet log) throws SQLException {
		while (log.next()) {
			try {
				this.email = log.getString(1);
				this.senha = log.getString(2);
				this.dataMes = log.getString(3);
				this.vitorias = log.getString(4);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Jogador() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDataMes() {
		return dataMes;
	}

	public void setDataMes(String dataMes) {
		this.dataMes = dataMes;
	}

	public String getVitorias() {
		return vitorias;
	}

	public void setVitorias(String vitorias) {
		this.vitorias = vitorias;
	}

}
