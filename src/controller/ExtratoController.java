package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Lancamento;
import dao.LancamentoDao;

@WebServlet("/ExtratoController")
public class ExtratoController extends HttpServlet{
	private LancamentoDao dao = new LancamentoDao();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		if("Mostrar Extrato".equals(cmd)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date txtDataInicio  = sdf.parse(req.getParameter("txtDataInicio"));
				Date txtDataFim = sdf.parse(req.getParameter("txtDataFim"));
				List<Lancamento> extrato = dao.consultar(txtDataInicio, txtDataFim);
				req.setAttribute("EXTRATO", extrato);
				if(extrato.size() == 0){
					req.setAttribute("MENSAGEM","não há lançamentos para este período especificado");
				}
				
			} catch (ParseException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}
		resp.sendRedirect("extrato.jsp");
	}
}
