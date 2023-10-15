package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.BookService;
import service.BookServiceImpl;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/*.do")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	  response.setContentType("text/html; charset=UTF-8");
	  
	  String requestURI = request.getRequestURI();
	  String contextPath = request.getContextPath();
	  String urlMapping = requestURI.substring(contextPath.length());
	  
	  ActionForward af = null;
	  
	  BookService bookService = new BookServiceImpl();
	  
	  // 요청에 따른 처리
    switch(urlMapping) {
    // 단순 이동 (forward 처리)
    case "/book/write.do":
      af = new ActionForward("/book/write.jsp", false);
      break;
    case "/book/index.do":
      af = new ActionForward("/index.jsp", false);
      break;
    // 서비스 처리
    case "/book/register.do":
      af = bookService.register(request);
      break;
    case "/book/list.do":
      af = bookService.getBookList(request);
      break;
    case "/book/detail.do":
      af = bookService.getBookByNo(request);
      break;
    case "/book/edit.do":
      af = bookService.edit(request);
      break;
    case "/book/modify.do":
      af = bookService.modify(request);
      break;
    case "/book/delete.do":
      af = bookService.delete(request);
      break;
    }
    
    // 이동
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
