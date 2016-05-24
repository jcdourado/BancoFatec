package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.UsuarioConta;

public class UsuarioContaDao {
	public boolean adicionar(UsuarioConta u) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "INSERT INTO USUARIOCONTA(IDUSUARIO,IDCONTA) VALUES (?,?) ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, u.getIdUsuario());
		ps.setInt(2, u.getIdConta());
		return ps.execute();
	}
	
	public boolean remover(int id) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "DELETE FROM USUARIOCONTA WHERE ID = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.execute();
	}
	
	public boolean alterar(UsuarioConta u) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "UPDATE USUARIOCONTA SET IDUSUARIO = ?, IDCONTA = ? WHERE ID = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, u.getIdUsuario());
		ps.setInt(2, u.getIdConta());
		ps.setInt(3, u.getId());
		return ps.execute();
	}
}
