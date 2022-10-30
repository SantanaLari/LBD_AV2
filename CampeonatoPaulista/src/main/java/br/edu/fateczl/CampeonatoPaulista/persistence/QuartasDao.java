package br.edu.fateczl.CampeonatoPaulista.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.CampeonatoPaulista.model.Grupos;
import br.edu.fateczl.CampeonatoPaulista.model.Times;

@Repository
public class QuartasDao implements IQuartasDao {

	@Autowired
	GenericDao gDao; 
	
	@Override
	public List<Grupos> consultaGruposA() throws SQLException, ClassNotFoundException {
		List<Grupos> grupos = new ArrayList<Grupos>();
		
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM fn_quartas('A') ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Grupos g = new Grupos();
			
			Times t = new Times();
			t.setNomeTime(rs.getString("nomeTime"));
			g.setCodigoTime(t);
			
			grupos.add(g);
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return grupos;
	}

	@Override
	public List<Grupos> consultaGruposB() throws SQLException, ClassNotFoundException {
		List<Grupos> grupos = new ArrayList<Grupos>();
		
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM fn_quartas('B') ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Grupos g = new Grupos();
			
			Times t = new Times();
			t.setNomeTime(rs.getString("nomeTime"));
			g.setCodigoTime(t);
			
			grupos.add(g);
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return grupos;
	}

	@Override
	public List<Grupos> consultaGruposC() throws SQLException, ClassNotFoundException {
		List<Grupos> grupos = new ArrayList<Grupos>();
		
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM fn_quartas('C') ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Grupos g = new Grupos();
			
			Times t = new Times();
			t.setNomeTime(rs.getString("nomeTime"));
			g.setCodigoTime(t);
			
			grupos.add(g);
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return grupos;
	}

	@Override
	public List<Grupos> consultaGruposD() throws SQLException, ClassNotFoundException {
		List<Grupos> grupos = new ArrayList<Grupos>();
		
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM fn_quartas('D') ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Grupos g = new Grupos();
			
			Times t = new Times();
			t.setNomeTime(rs.getString("nomeTime"));
			g.setCodigoTime(t);
			
			grupos.add(g);
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return grupos;
	}

}
