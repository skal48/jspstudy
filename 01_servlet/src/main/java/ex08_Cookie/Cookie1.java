package ex08_Cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookie1
 */
@WebServlet("/cookie1")
public class Cookie1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookie1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 쿠키 
		 * 1. 클라이언트 측에 저장되는 정보를 의미한다. 
		 * 2. 보안에는 취약하므로 개인정보 같은 민감 정보는 저장하지 않는다. 
		 * 
		 */
	  
	  // 쿠키만들기
	  Cookie cookie1 = new Cookie("name","홍길동");  //쿠키로 저장할 수 있는것은 String 만 가능하다. 
	  Cookie cookie2 = new Cookie("age", "20");
	  Cookie cookie3 = new Cookie("address", URLEncoder.encode("서울특별시 종로구", "UTF-8"));  // 공백은 유효하지 않은 문자이므로 인코딩이 필요하다 . 
	  
	  // 쿠키가 저장될 경로 설정하기 (생략하면 컨텍스트패스 경로에 저장된다. )
	  cookie1.setPath("/servlet");  //컨텍스트패스 request.getContextPath() 를 이용해서 알아낼 수 있다.
	  cookie2.setPath("/servlet/cookie1"); // 서블릿 경로   :  request.getRequestURI()  coookie1 에 저장되어 있어서 cookie2에서는 안보인다. 
	                                      // cookie3은 경로 설정을 생략했으므로 컨텍스트패스에 저장된다. 
	  
	  //  쿠키가 유지되는 시간 설정하기 (생략하면 세션쿠기가 된다. 브라우저를 닫으면 지워진다.
	  cookie1.setMaxAge(60 * 60);  // 1시간 60초 곱하기 60분 
	  cookie2.setMaxAge(7 * 24 * 60 * 60); //7일
	                                       // cookie3은 시간 설정을 생략했으므로 세션쿠기가 된다. 
	  // 쿠키를 브라우저에 저장하기 (응답으로 처리한다)
	  response.addCookie(cookie1);
	  response.addCookie(cookie2);
	  response.addCookie(cookie3);
	  
	  // Cookie2 서블릿으로 redirect 이동 
	  response.sendRedirect("/servlet/cookie2");   //forward가 아니라서 /cookies 가 아니다. 
	  
	  
	  // 쿠키는 삭제라는 것이 없고 시간설정을 0으로 해준다음에 저장하면 0이 된다. 
	  
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
