package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happyhouse.dto.APT;

import service.APTService;
import service.APTServiceImpl;

/**
 * Servlet implementation class APTController
 */
@WebServlet("/apt")
public class APTController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private APTService aptService = new APTServiceImpl();
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("search")) doSearch(request, response);		
	}

	private void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		List<APT> aptList = new ArrayList<APT>();
		String dong = request.getParameter("dong");
		String[] dongLocation = aptService.dongLocation(dong);
		aptList = aptService.search(dong);
		request.setAttribute("aptlist", aptList);
		request.setAttribute("donglat", dongLocation[0]);
		request.setAttribute("donglng", dongLocation[1]);
		System.out.println(dongLocation[0] + "  | " + dongLocation[1] );
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
