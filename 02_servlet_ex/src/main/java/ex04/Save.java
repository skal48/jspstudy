package ex04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Save
 */
@WebServlet("/save")
public class Save extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * @see HttpServlet#HttpServlet()
   */
  public Save() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // 저장할 파일명 선언
    String filename = null;
    
    // 파일 생성 시 예외 발생 여부에 따라 응답 메시지를 다르게 생성하기 위해서 try catch 사용함
    try {
      
      // 요청 인코딩
      request.setCharacterEncoding("UTF-8");
      
      // 요청 파라미터
      String writer = request.getParameter("writer");
      String title = request.getParameter("title");
      String content = request.getParameter("content");
      
      // 저장할 디렉터리 (없으면 만들기)
      File dir = new File("C:/storage");
      if(!dir.exists() == false) {
        dir.mkdirs();
      }
      
      // 저장할 파일명 (날짜-작성자-제목.txt)
      filename = LocalDate.now().toString() + "-" + writer + "-" + title + ".txt";
      
      // 저장할 파일의 File 객체
      File file = new File(dir, filename);
      BufferedWriter bw = new BufferedWriter(new FileWriter(file));
      bw.write(content);
      bw.flush();
      bw.close();
      
      /* 정상 처리 상황의 응답 처리 */
      
      // 응답 타입과 인코딩
      response.setContentType("text/html; charset=UTF-8");
      
      // 응답 출력 스트림 생성
      PrintWriter out = response.getWriter();
      
      // 응답하기
      out.println("<script>");
      out.println("alert('" + filename + "  파일이 생성되었습니다.')");
      out.println("location.href='/servlet_ex/ex04/NewFile.html'");
      out.println("</script>");
      out.flush();
      out.close();
      
    } catch(Exception e) {
      
      /* 예외 상황의 응답 처리 */
      
      // 응답 타입과 인코딩
      response.setContentType("text/html; charset=UTF-8");
      
      // 응답 출력 스트림 생성
      PrintWriter out = response.getWriter();
      
      // 응답하기
      out.println("<script>");
      out.println("alert('" + filename + "  파일 생성에 실패했습니다.')");
      out.println("history.back()");
      out.println("</script>");
      out.close();
      
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
