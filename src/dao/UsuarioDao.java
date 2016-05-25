package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDao {
	
	public boolean adicionar(Usuario u) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "INSERT INTO USUARIO(USUARIO,NOME,EMAIL,TELEFONE,SENHA,PERFIL) VALUES (?,?,?,?,?,?) ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getUsuario());
		ps.setString(2, u.getNome());
		ps.setString(3, u.getEmail());
		ps.setString(4, u.getTelefone());
		ps.setString(5, u.getTelefone());
		ps.setString(6, u.getPerfil());
		return ps.execute();
	}
	
	public boolean remover(int id) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "DELETE FROM USUARIO WHERE ID = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.execute();
	}
	
	public boolean alterar(Usuario u) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "UPDATE USUARIO SET USUARIO = ?, NOME = ?,EMAIL = ?,TELEFONE = ?,SENHA = ?,PERFIL = ? WHERE ID = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getUsuario());
		ps.setString(2, u.getNome());
		ps.setString(3, u.getEmail());
		ps.setString(4, u.getTelefone());
		ps.setString(5, u.getTelefone());
		ps.setString(6, u.getPerfil());
		ps.setInt(7, u.getId());
		return ps.execute();
	}

	public Usuario consultar(String txtUsuario, String txtSenha) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "SELECT * FROM USUARIO WHERE USUARIO = ? AND SENHA = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, txtUsuario);
		ps.setString(2, txtSenha);
		Usuario u = null;
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			u = new Usuario();
			u.setNome(txtUsuario);
			u.setSenha(txtSenha);
			u.setId(rs.getInt("id"));
			u.setPerfil(rs.getString("perfil"));
			u.setEmail(rs.getString("email"));
			u.setTelefone(rs.getString("telefone"));
		}
		ps.close();
		return u;
	}
}
