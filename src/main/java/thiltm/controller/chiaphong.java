package thiltm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import thiltm.model.danhsach;

@WebServlet("/chiaphong")
public class chiaphong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public chiaphong() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		danhsach ds = new danhsach();
		ds.setGv((XSSFWorkbook) request.getSession().getAttribute("gv"));
		ds.setPt((XSSFWorkbook) request.getSession().getAttribute("pt"));
		ds.xuly(request.getSession().getAttribute("ca").toString());
		request.getSession().setAttribute("dspc", ds.getDspc());
		request.getSession().setAttribute("dsgs", ds.getDsgs());
		response.sendRedirect("result.jsp");	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
