package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Conta;

public class ContaDao {
	public boolean adicionar(Conta c) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "INSERT INTO CONTA(TIPO,NUMERO,SALDO,LIMITE,TAXASERVICO,TAXAJUROS,TAXARENDIMENTO,DATAABERTURA,DIARENDIMENTO,NOMEGERENTE) VALUES (?,?,?,?,?,?,?,?,?,?) ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, c.getTipo());
		ps.setString(2, c.getNumero());
		ps.setFloat(3, c.getSaldo());
		ps.setFloat(4, c.getLimite());
		ps.setFloat(5, c.getTaxaServico());
		ps.setFloat(6, c.getTaxaJuros());
		ps.setFloat(7, c.getTaxaRendimento());
		ps.setDate(8, new Date(c.getDataAbertura().getTime()));
		ps.setFloat(9, c.getDiaRendimento());
		ps.setString(10, c.getNomeGerente());
		return ps.execute();
	}
	
	public boolean remover(int id) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "DELETE FROM CONTA WHERE ID = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.execute();
	}
	
	public boolean alterar(Conta c) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "UPDATE CONTA SET TIPO = ?,NUMERO = ?,SALDO = ?,LIMITE = ?,TAXASERVICO = ?,TAXAJUROS = ?,TAXARENDIMENTO = ?,DATAABERTURA = ?,DIARENDIMENTO = ?,NOMEGERENTE  = ? WHERE ID = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, c.getTipo());
		ps.setString(2, c.getNumero());
		ps.setFloat(3, c.getSaldo());
		ps.setFloat(4, c.getLimite());
		ps.setFloat(5, c.getTaxaServico());
		ps.setFloat(6, c.getTaxaJuros());
		ps.setFloat(7, c.getTaxaRendimento());
		ps.setDate(8, new Date(c.getDataAbertura().getTime()));
		ps.setFloat(9, c.getDiaRendimento());
		ps.setString(10, c.getNomeGerente());
		ps.setInt(11, c.getId());
		return ps.execute();
	}
	
	public Conta consultar(int idConta) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "SELECT * FROM CONTA WHERE ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idConta);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			Conta c= new Conta();
			c.setId(idConta);
			c.setTipo(rs.getString("tipo"));
			c.setNumero(rs.getString("numero"));
			c.setSaldo(rs.getFloat("saldo"));
			c.setLimite(rs.getFloat("limite"));
			c.setTaxaServico(rs.getFloat("taxaservico"));
			c.setTaxaRendimento(rs.getFloat("taxarendimento"));
			c.setTaxaJuros(rs.getFloat("taxajuros"));
			c.setDataAbertura(new java.util.Date(rs.getDate("dataabertura").getTime()));
			c.setDiaRendimento(rs.getFloat("diarendimento"));
			c.setNomeGerente(rs.getString("nomegerente"));
			return c;
		}
		return null;
	}
}
