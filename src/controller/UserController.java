package controller;

import java.io.IOException;
import java.util.NoSuchElementException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.happyhouse.dto.Userinfo;

import service.UserService;
import service.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	UserService userService = new UserServiceImpl();
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		process(request,response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("login")) doLogin(request,response);
		if(action.equals("logout")) doLogout(request,response);
		if(action.equals("join")) doJoin(request,response);
		if(action.equals("pwFind")) doPwFind(request,response);
		if(action.equals("modify")) doModify(request,response);
		if(action.equals("delete")) doDeleteid(request,response);
	}

	private void doDeleteid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		HttpSession session = request.getSession();
		Userinfo user = (Userinfo) session.getAttribute("userinfo");
		userService.DeleteId(user.getId());
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	private void doModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		
		Userinfo user = new Userinfo(id,pw,name,tel,addr);
		userService.Modify(user);
		
		HttpSession session = request.getSession();
		session.setAttribute("userinfo", user);
		response.sendRedirect("userinfo.jsp");
		
	}

	private void doPwFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String tel  = request.getParameter("tel");
		Userinfo user = userService.select(id);
		
		if(user != null) {
			if(name.equals(user.getName()) && tel.equals(user.getTel())) {
				request.setAttribute("FindedPw",user.getPwd());
			}
		}
		else {
			request.setAttribute("FindedPw", "정보가 일치하지 않습니다." );
		}
		request.getRequestDispatcher("pwFind.jsp").forward(request, response);
		
	}

	private void doJoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		
		Userinfo user = new Userinfo(id,pw,name,tel,addr);
		
		if(userService.join(user) ==1 ) {
			response.sendRedirect("index.jsp");
		} else {
			request.setAttribute("msg","이미 존재하는 아이디입니다. ");
			request.getRequestDispatcher("signUp.jsp").forward(request, response);
		}
	}

	private void doLogout(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		HttpSession session = request.getSession();
		try {
			Userinfo user = userService.select(id);
			if(user!=null ) {
				if(pw.equals(user.getPwd())) {
					session.setAttribute("userinfo", user);
				} else {
					request.setAttribute("msg", "아이디 또는 비밀번호가 잘못 되었습니다.");					
				}	
			}
		} catch(Exception e) {
			request.setAttribute("msg", "아이디 또는 비밀번호가 잘못 되었습니다.");
		} finally {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}

}
