package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ConsultaGrupo;
import model.Times;

public class PlacarDao implements IPlacarDao {

	private GenericDao gDao;
	
	public PlacarDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public List<ConsultaGrupo> consultaClassificacao() throws SQLException, ClassNotFoundException {
		List<ConsultaGrupo> grupos = new ArrayList<ConsultaGrupo>();
		
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM fn_placarGeral() ");
		sql.append("ORDER BY vitorias DESC, gols_marcados DESC, saldo_gols DESC");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ConsultaGrupo gp = new ConsultaGrupo();
			gp.setNum_jogos_disputados(rs.getInt("num_jogos_disputados"));
			gp.setVitorias(rs.getInt("vitorias"));
			gp.setEmpates(rs.getInt("empates"));
			gp.setDerrotas(rs.getInt("derrotas"));
			gp.setGols_marcados(rs.getInt("gols_marcados"));
			gp.setGols_sofridos(rs.getInt("gols_sofridos"));
			gp.setSaldo_gols(rs.getInt("saldo_gols"));
			gp.setPontos(rs.getInt("pontos"));
			
			Times t = new Times();
			t.setNomeTime(rs.getString("nomeTime"));
			gp.setNomeTime(t);
			
			grupos.add(gp);
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return grupos;
	}

	@Override
	public List<ConsultaGrupo> consultaGrupo(String grupo) throws SQLException, ClassNotFoundException {
		List<ConsultaGrupo> grupos = new ArrayList<ConsultaGrupo>();
		
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM fn_placarGrupo((?)) ");
		sql.append("ORDER BY vitorias DESC, gols_marcados DESC, saldo_gols DESC");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setString(1, grupo);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ConsultaGrupo gp = new ConsultaGrupo();
			gp.setNum_jogos_disputados(rs.getInt("num_jogos_disputados"));
			gp.setVitorias(rs.getInt("vitorias"));
			gp.setEmpates(rs.getInt("empates"));
			gp.setDerrotas(rs.getInt("derrotas"));
			gp.setGols_marcados(rs.getInt("gols_marcados"));
			gp.setGols_sofridos(rs.getInt("gols_sofridos"));
			gp.setSaldo_gols(rs.getInt("saldo_gols"));
			gp.setPontos(rs.getInt("pontos"));
			
			Times t = new Times();
			t.setNomeTime(rs.getString("nomeTime"));
			gp.setNomeTime(t);
			
			grupos.add(gp);
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return grupos;
	}
	
	@Override
	public List<ConsultaGrupo> grupoRebaixado() throws SQLException, ClassNotFoundException {
		List<ConsultaGrupo> grupos = new ArrayList<ConsultaGrupo>();
		
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select TOP(2) * from fn_placarGeral() ");
		sql.append("WHERE gols_marcados IS NOT NULL ");
		sql.append("ORDER BY vitorias ASC, gols_marcados ASC, saldo_gols ASC ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ConsultaGrupo gp = new ConsultaGrupo();
			gp.setNum_jogos_disputados(rs.getInt("num_jogos_disputados"));
			gp.setVitorias(rs.getInt("vitorias"));
			gp.setEmpates(rs.getInt("empates"));
			gp.setDerrotas(rs.getInt("derrotas"));
			gp.setGols_marcados(rs.getInt("gols_marcados"));
			gp.setGols_sofridos(rs.getInt("gols_sofridos"));
			gp.setSaldo_gols(rs.getInt("saldo_gols"));
			gp.setPontos(rs.getInt("pontos"));
			
			Times t = new Times();
			t.setNomeTime(rs.getString("nomeTime"));
			gp.setNomeTime(t);
			
			grupos.add(gp);
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return grupos;
	}

}
