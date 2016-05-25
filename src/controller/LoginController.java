package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContaDao;
import dao.UsuarioContaDao;
import dao.UsuarioDao;
import model.Conta;
import model.Usuario;
import model.UsuarioConta;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet{
	private UsuarioDao daoUsuario = new UsuarioDao();
	private UsuarioContaDao daoUsuarioConta = new UsuarioContaDao();
	private ContaDao daoConta = new ContaDao();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		if("Login".equals(cmd)){
			String usuario = req.getParameter("txtUsuario");
			String senha = req.getParameter("txtSenha");
			Usuario u = null;
			try {
				if((u = daoUsuario.consultar(usuario, senha)) != null){
					req.getSession().setAttribute("PERFIL", u);
					UsuarioConta uConta = daoUsuarioConta.consultar(u.getId());
					if(uConta != null){
						Conta conta = daoConta.consultar(uConta.getIdConta());
						req.getSession().setAttribute("CONTA", conta);
					}
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		resp.sendRedirect("login.jsp");
	}
}
