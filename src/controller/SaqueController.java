package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LancamentoDao;
import model.Conta;
import model.Lancamento;

@WebServlet("/SaqueController")
public class SaqueController extends HttpServlet{
	private LancamentoDao daoLancamento = new LancamentoDao();
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		if("Saque".equals(cmd)){
			String valor = req.getParameter("txtValor");
			String desc = req.getParameter("txtDescricao");
			Lancamento l = new Lancamento();
			Conta cSession = (Conta) req.getSession().getAttribute("CONTA");
			l.setIdConta(cSession.getId());
			l.setTipo("Saque");
			l.setDescricao(desc);
			l.setSaldoAnterior(cSession.getSaldo());
			cSession.setSaldo(cSession.getSaldo() - Float.parseFloat(valor));
			l.setSaldoPosterior(cSession.getSaldo());
			l.setValor(Float.parseFloat(valor));
			l.setDataLancamento(new Date());
			try {
				if(!daoLancamento.adicionar(l)){
					req.setAttribute("MENSAGEM","saque efetuado com sucesso");
				}
				else{
					req.setAttribute("MENSAGEM","erro ao efetuar o saque");
				}
			} catch (ClassNotFoundException | SQLException e) {
				req.setAttribute("MENSAGEM","erro ao efetuar o saque");
				e.printStackTrace();
			}
		}
		resp.sendRedirect("saque.jsp");
	}

}
