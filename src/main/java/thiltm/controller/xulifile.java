package thiltm.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@WebServlet("/xulifile")
public class xulifile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public xulifile() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory())
					.parseRequest(new ServletRequestContext(request));
			for (FileItem item : items)
				if (!item.isFormField()) {
					BufferedInputStream bis = new BufferedInputStream(item.getInputStream());
					if (item.getName().isEmpty()) {
						break;
					} else {
						XSSFWorkbook workbook = new XSSFWorkbook(bis);
						System.out.println(item.getFieldName());
						if (item.getFieldName().equals("gv"))
							request.getSession().setAttribute("gv", workbook);
						else
							request.getSession().setAttribute("pt", workbook);
					}
				} else {
					request.getSession().setAttribute("ca", item.getString());
				}
		} catch (Exception e) {
		}
		System.out.println(request.getSession().getAttribute("ca"));
		if (request.getSession().getAttribute("gv") == null || request.getSession().getAttribute("pt") == null
				|| request.getSession().getAttribute("ca").toString().isEmpty()) {
			response.sendRedirect("index.jsp");
			System.out.println("index");
		}
		else {
			response.sendRedirect("chiaphong");
			System.out.println("chiaphong");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
