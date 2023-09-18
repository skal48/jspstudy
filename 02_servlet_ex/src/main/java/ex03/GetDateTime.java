package ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDateTime
 */
@WebServlet("/datetime")
public class GetDateTime extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * @see HttpServlet#HttpServlet()
   */
  public GetDateTime() {
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
    String type = request.getParameter("type");
    
    String result = null;
    switch(type) {
    case "1":  // 현재 날짜 요청
      result = LocalDate.now().toString();
      break;
    case "2":  // 현재 시간 요청
      result = LocalTime.now().toString();
      result = result.substring(0, result.indexOf("."));
      break;
    }
    
    // 응답 타입과 인코딩
    response.setContentType("text/html; charset=UTF-8");
    
    // 응답 출력 스트림 생성
    PrintWriter out = response.getWriter();
    
    // 응답 만들기
    out.println("<script>");
    out.println("alert('요청 결과는 " + result + "입니다.')");
    out.println("history.back()");  // 이전 화면으로 이동하기
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
