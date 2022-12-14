package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Jogos;

public class ResultadosDao implements IResultadosDao {

	private GenericDao gDao;
	
	public ResultadosDao (GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public String insereResultados(String nomeTimeA, String nomeTimeB, int golsTimeA, int golsTimeB) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "{CALL sp_resultado ?, ?, ?, ?} ";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, nomeTimeA);
		cs.setString(2, nomeTimeB);
		cs.setInt(3, golsTimeA);
		cs.setInt(4, golsTimeB);
		cs.execute();
		cs.close();
		
		return "Resultado inserido.";
	}

	@Override
	public List<Jogos> consultaResultados() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT CodigoTimeA, CodigoTimeB, GolsTimeA, GolsTimeB, Data ");
		sql.append("FROM jogos ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Jogos j = new Jogos();
			j.setCodigoTimeA(rs.getInt("CodigoTimeA"));
			j.setCodigoTimeB(rs.getInt("CodigoTimeB"));
			j.setGolsTimeA(rs.getInt("GolsTimeA"));
			j.setGolsTimeB(rs.getInt("GolsTimeB"));
			j.setData(rs.getString("Data"));
			
			jogos.add(j);
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return jogos;
	}

}