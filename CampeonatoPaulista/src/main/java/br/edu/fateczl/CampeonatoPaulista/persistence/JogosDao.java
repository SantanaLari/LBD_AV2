package br.edu.fateczl.CampeonatoPaulista.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.CampeonatoPaulista.model.Jogos;

@Repository
public class JogosDao implements IJogosDao {

	@Autowired
	GenericDao gDao;
	
	@Override
	public String criarJogos() throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "{CALL pro_partidasT1}";
		CallableStatement cs = c.prepareCall(sql);
		cs.execute();
		String saida = "Jogos gerados";
		
		return saida;
	}
	
	
	@Override
	public String excluirJogos() throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "DELETE jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.execute();
		ps.close();
		c.close();
		return "Jogos excluidos";
	}

	@Override
	public List<Jogos> consultaJogos() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT CodigoTimeA, CodigoTimeB ");
		sql.append("FROM jogos ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Jogos j = new Jogos();
			j.setCodigoTimeA(rs.getInt("CodigoTimeA"));
			j.setCodigoTimeB(rs.getInt("CodigoTimeB"));
			
			jogos.add(j);
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return jogos;
	}
	
	@Override
	public List<Jogos> consultaDatas() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT CodigoTimeA, CodigoTimeB ");
		sql.append("FROM jogos ");
		sql.append("WHERE jg.Data = ? ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Jogos j = new Jogos();
			j.setData(rs.getString("data"));
			
			jogos.add(j);
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return jogos;
	}

}