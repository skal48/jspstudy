package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Gugudan
 */
@WebServlet("/gugudan")
public class Gugudan extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * @see HttpServlet#HttpServlet()
   */
  public Gugudan() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
     // 요청 인코딩
    request.setCharacterEncoding("UTF-8");
    
    // 요청 파라미터
    String strDan = request.getParameter("dan");
    String strNum = request.getParameter("num");
    String strResult = request.getParameter("result");
    
    // 공백 및 null 처리 후 숫자로 변환하기
    int dan = 0, num = 0, result = 0;
    if(strDan != null && !strDan.isEmpty()) {
      dan = Integer.parseInt(strDan);
    }
    if(strNum != null && !strNum.isEmpty()) {
      num = Integer.parseInt(strNum);
    }
    if(strResult != null && !strResult.isEmpty()) {
      result = Integer.parseInt(strResult);
    }
    
    // 응답 타입과 인코딩
    response.setContentType("text/html; charset=UTF-8");
    
    // 응답 출력 스트림 생성
    PrintWriter out = response.getWriter();
    
    // 응답하기
    out.println("<script>");
    if(dan * num == result) {
      out.println("alert('정답입니다.')");
    } else {
      out.println("alert('오답입니다.')");
    }
    out.println("location.href='/servlet_ex/ex02/NewFile.html'");
    out.println("</script>");
    out.flush();
    out.close();
    
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
