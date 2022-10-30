package br.edu.fateczl.CampeonatoPaulista.persistence;

import java.sql.SQLException;
import java.util.List;
import br.edu.fateczl.CampeonatoPaulista.model.Jogos;

public interface IJogosDao {
	
	public String criarJogos() throws SQLException, ClassNotFoundException;
	public String excluirJogos() throws SQLException, ClassNotFoundException;
	public List<Jogos> consultaJogos() throws SQLException, ClassNotFoundException;
	public List<Jogos> consultaDatas() throws SQLException, ClassNotFoundException;
}