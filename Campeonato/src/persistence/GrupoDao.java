package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Grupos;
import model.Times;

public class GrupoDao implements IGrupoDao {

	private GenericDao gDao;
	
	public GrupoDao (GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public String criarGrupos() throws SQLException, ClassNotFoundException {
		excluirGrupos();
		Connection c = gDao.getConnection();
		String sql = "{CALL p_geraGrupo}";
		CallableStatement cs = c.prepareCall(sql);
		cs.execute();
		String saida = "Grupos gerados";
		
		JogosDao jd = new JogosDao(gDao);
		jd.criarJogos();
		
		return saida;
	}

	@Override
	public String excluirGrupos() throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "DELETE grupos";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.execute();
		ps.close();
		c.close();
		
		return "Grupos excluidos";
	}

	@Override
	public List<Grupos> consultaGruposA() throws SQLException, ClassNotFoundException {
		List<Grupos> grupos = new ArrayList<Grupos>();
		
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT gp.Grupo, tm.NomeTime ");
		sql.append("FROM grupos gp, times tm ");
		sql.append("WHERE tm.CodigoTime = gp.CodigoTime ");
		sql.append("AND gp.Grupo = 'A' ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Grupos g = new Grupos();
			g.setGrupo(rs.getString("Grupo"));
			
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
		sql.append("SELECT gp.Grupo, tm.NomeTime ");
		sql.append("FROM grupos gp, times tm ");
		sql.append("WHERE tm.CodigoTime = gp.CodigoTime ");
		sql.append("AND gp.Grupo = 'B' ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Grupos g = new Grupos();
			g.setGrupo(rs.getString("Grupo"));
			
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
		sql.append("SELECT gp.Grupo, tm.NomeTime ");
		sql.append("FROM grupos gp, times tm ");
		sql.append("WHERE tm.CodigoTime = gp.CodigoTime ");
		sql.append("AND gp.Grupo = 'C' ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Grupos g = new Grupos();
			g.setGrupo(rs.getString("Grupo"));
			
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
		sql.append("SELECT gp.Grupo, tm.NomeTime ");
		sql.append("FROM grupos gp, times tm ");
		sql.append("WHERE tm.CodigoTime = gp.CodigoTime ");
		sql.append("AND gp.Grupo = 'D' ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Grupos g = new Grupos();
			g.setGrupo(rs.getString("Grupo"));
			
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
