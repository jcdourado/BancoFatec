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

@WebServlet("/TransferenciaController")
public class TransferenciaController extends HttpServlet{
	private LancamentoDao daoLancamento = new LancamentoDao();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		if("Transferir".equals(cmd)){
			String txtNumeroConta = req.getParameter("txtNumeroConta");
			String txtTitular = req.getParameter("txtTitular");
			String txtValor = req.getParameter("txtValor");
			String txtDescricao = req.getParameter("txtDescricao");
			Lancamento l = new Lancamento();
			Conta cSession = (Conta) req.getSession().getAttribute("CONTA");
			l.setIdConta(cSession.getId());
			l.setTipo("Transferencia");
			l.setDescricao("Trasnferido para conta " + txtNumeroConta + ", titularidade " + txtTitular  + " referente : " + txtDescricao);
			l.setSaldoAnterior(cSession.getSaldo());
			cSession.setSaldo(cSession.getSaldo() - Float.parseFloat(txtValor));
			l.setSaldoPosterior(cSession.getSaldo());
			l.setValor(Float.parseFloat(txtValor));
			l.setDataLancamento(new Date());
			try {
				if(!daoLancamento.adicionar(l)){
					req.setAttribute("MENSAGEM","transferência efetuada com sucesso");
				}
				else{
					req.setAttribute("MENSAGEM","erro ao efetuar a transferencia");
				}
			} catch (ClassNotFoundException | SQLException e) {
				req.setAttribute("MENSAGEM","erro ao efetuar a transferencia");
				e.printStackTrace();
			}
		}
		resp.sendRedirect("transferencia.jsp");
	}
}
