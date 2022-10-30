package br.edu.fateczl.CampeonatoPaulista.persistence;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.CampeonatoPaulista.model.Jogos;

public interface IResultadosDao {

	public String insereResultados(String nomeTimeA, String nomeTimeB, int golsTimeA, int golsTimeB, String data) throws SQLException, ClassNotFoundException; 
	public List<Jogos> consultaResultados() throws SQLException, ClassNotFoundException;
	
}
