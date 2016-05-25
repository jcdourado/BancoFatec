package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Lancamento> consultar(java.util.Date inicio,java.util.Date fim) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "SELECT * FROM LANCAMENTO WHERE DATALANCAMENTO BETWEEN ? AND ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDate(1, new Date(inicio.getTime()));
		ps.setDate(2, new Date(fim.getTime()));
		ResultSet rs = ps.executeQuery();
		List<Lancamento> lancamentos = new ArrayList<Lancamento>();
		while(rs.next()){
			Lancamento l = new Lancamento();
			l.setId(rs.getInt("id"));
			l.setIdConta(rs.getInt("idconta"));
			l.setTipo(rs.getString("tipo"));
			l.setDescricao(rs.getString("descricao"));
			l.setSaldoAnterior(rs.getFloat("saldoanterior"));
			l.setSaldoPosterior(rs.getFloat("saldoposterior"));
			l.setValor(rs.getFloat("valor"));
			l.setDataLancamento(new java.util.Date(rs.getDate("datalancamento").getTime()));
			lancamentos.add(l);
		}
		return lancamentos;
	}
}
