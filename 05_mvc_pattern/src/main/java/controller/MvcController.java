package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.MvcService;
import service.MvcServiceImpl;

/**
 * Servlet implementation class MvcController
 */
@WebServlet("*.do")
public class MvcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MvcController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 인코딩 +  응답 타입과 잍코딩
	  request.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html; charset=UTF-8");
	  
	  //요청 확인(URLMApping 확인)
	  String requestURI =request.getRequestURI();        /* /mvc/getData.do */
	  String contextPath = request.getContextPath();     /* /mvc  */
	  String urlMapping  = requestURI.substring(contextPath.length()); /*/getDate.do*/
	  
	  // 서비스 객체  생성(MVC Pattern 에서 Model에 해당함)
	  MvcService mvcService = new MvcServiceImpl();
	  //서비스 실행 결과 (어디로 어떻게 이동해야 하는가)
	 ActionForward af = null;
	  
	  
	  
	  switch(urlMapping) {
	  case "/getDate.do":
	    af = mvcService.getDate(request);
	    break;
	  case "/getTime.do":
	    af = mvcService.getTime(request);
	    break;
	  case "/getDatetime.do":
	    mvcService.getDatetime(request, response); // 반환타입이 void 라서 af 안붙임 
	    
	    break;
	      
	  }
	  
	  // 서비스 실행 경과에 의한 이동(redirect와  forward의 선택은 서비스에서 결정함
	  if(af != null) {
	    if(af.isRedirect()) {
	      response.sendRedirect(af.getPath());
	    } else {
	      request.getRequestDispatcher(af.getPath()).forward(request, response);
	      
	    }
	    
	  }
	  
	  
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
