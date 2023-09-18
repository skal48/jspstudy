package ex07_cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RememberMe
 */
@WebServlet("/rememberMe")
public class RememberMe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RememberMe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  // 요청 인코딩
	  request.setCharacterEncoding("UTF-8");
	  
	  //요청 파라미터 (id, remember_me)
	  String id = request.getParameter("id"); //입력상자의 입력이 없으면 
	  String remember_me = request.getParameter("remember_me"); //checkbox의 입력이 없으면 null
	  	  
	  // 아이디 기억하기 체크 했다면
	  Cookie cookie = null; 
	  if(remember_me != null) { // if(remember_me.equals("on")){과동일함 
	    cookie = new Cookie("remember_me", id);
	    cookie.setMaxAge(60 * 60 * 24 * 15); //15일 간 쿠키 유지
	    
	  }else {
	    cookie = new Cookie("remeber_id","");
	    cookie.setMaxAge(0);  //쿠키 삭제를 위해 0초간 유지 
	  }
	  
	  // 쿠키는 클라이언트에세 전달한다. 
	  response.addCookie(cookie);
	  
	  // main으로 돌아가기
	  response.sendRedirect(request.getContextPath() + "/ex07_cookie/main.jsp");
	  
	  
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
