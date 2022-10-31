package persistence;

import java.sql.SQLException;
import java.util.List;

import model.ConsultaGrupo;

public interface IPlacarDao {
	
	//Metodo que retorna todos os grupos na pagina Classifica��o Geral
	public List<ConsultaGrupo> consultaClassificacao() throws SQLException, ClassNotFoundException;

	//Metodo que retorna cada grupo na pagina Consulta grupos
	public List<ConsultaGrupo> consultaGrupo(String grupo) throws SQLException, ClassNotFoundException;
	
	//Metodo que retorna grupos rebaixados em ambas as p�ginas
	public List<ConsultaGrupo> grupoRebaixado() throws SQLException, ClassNotFoundException;
	
}