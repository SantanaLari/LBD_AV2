package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Jogos;

public interface IResultadosDao {

	public String insereResultados(String nomeTimeA, String nomeTimeB, int golsTimeA, int golsTimeB) throws SQLException, ClassNotFoundException; 
	public List<Jogos> consultaResultados() throws SQLException, ClassNotFoundException;
	
}
