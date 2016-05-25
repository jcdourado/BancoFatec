package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExtratoController")
public class ExtratoController extends HttpServlet{

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

			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
	}
}
