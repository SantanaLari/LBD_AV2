package br.edu.fateczl.CampeonatoPaulista.persistence;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.CampeonatoPaulista.model.Grupos;

public interface IGrupoDao {
	
	public String criarGrupos() throws SQLException, ClassNotFoundException;
	public String excluirGrupos() throws SQLException, ClassNotFoundException;
	public List<Grupos> consultaGruposA() throws SQLException, ClassNotFoundException; 
	public List<Grupos> consultaGruposB() throws SQLException, ClassNotFoundException; 
	public List<Grupos> consultaGruposC() throws SQLException, ClassNotFoundException; 
	public List<Grupos> consultaGruposD() throws SQLException, ClassNotFoundException;  
	
}
