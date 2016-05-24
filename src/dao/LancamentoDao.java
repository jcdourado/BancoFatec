package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Lancamento;

public class LancamentoDao {
	public boolean adicionar(Lancamento l) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "INSERT INTO LANCAMENTO(IDCONTA,TIPO,DESCRICAO,SALDOANTERIOR,SALDOPOSTERIOR,VALOR,DATALANCAMENTO) VALUES (?,?,?,?,?,?,?) ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, l.getIdConta());
		ps.setString(2, l.getTipo());
		ps.setString(3, l.getDescricao());
		ps.setFloat(4, l.getSaldoAnterior());
		ps.setFloat(5, l.getSaldoPosterior());
		ps.setFloat(6, l.getValor());
		ps.setDate(7, new Date(l.getDataLancamento().getTime()));
		return ps.execute();
	}
	
	public boolean remover(int id) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "DELETE FROM LANCAMENTO WHERE ID = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.execute();
	}
	
	public boolean alterar(Lancamento l) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "UPDATE USUARIO SET IDCONTA = ?,TIPO = ?,DESCRICAO = ?,SALDOANTERIOR = ?,SALDOPOSTERIOR = ?,VALOR = ?,DATALANCAMENTO  = ? WHERE ID = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, l.getIdConta());
		ps.setString(2, l.getTipo());
		ps.setString(3, l.getDescricao());
		ps.setFloat(4, l.getSaldoAnterior());
		ps.setFloat(5, l.getSaldoPosterior());
		ps.setFloat(6, l.getValor());
		ps.setDate(7, new Date(l.getDataLancamento().getTime()));
		ps.setInt(8, l.getId());
		return ps.execute();
	}
}
