package ex05;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Papago
 */
@WebServlet("/papago")
public class Papago extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * @see HttpServlet#HttpServlet()
   */
  public Papago() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    URL url = null;
    HttpURLConnection con = null;
    BufferedOutputStream bout = null;  // 파파고 API로 데이터를 보낼 때 사용함 (POST 방식으로 보냄)
    BufferedReader reader = null;      // 파파고 API로부터 결과를 받을 때 사용함
    
    try {
      
      // 파파고 API 주소
      String spec = "https://openapi.naver.com/v1/papago/n2mt";
      
      // 클라이언트 아이디/시크릿 (본인 아이디와 시크릿으로 수정이 필요함)
      String clientId = "RTJMyHb54a63lvLzPh7A";
      String clientSecret = "0xR9yv0oo3";
      
      // 요청 인코딩
      request.setCharacterEncoding("UTF-8");
      
      // 요청 파라미터
      String source = request.getParameter("source");
      String target = request.getParameter("target");
      String text = request.getParameter("text");
      String params = "source=" + source + "&target=" + target+"&text=" + text;
      
      // URL 객체 생성과 접속 생성
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      
      // 요청 메소드 POST
      con.setRequestMethod("POST");
      
      // 요청 헤더 (clientId, clientSecret)
      con.setRequestProperty("X-Naver-Client-Id", clientId);
      con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
      
      // OutputStream을 이용해서 POST 데이터를 보내겠다.
      con.setDoOutput(true);
      
      // OutputStream을 이용해서 POST 데이터 보내기
      bout = new BufferedOutputStream(con.getOutputStream());
      bout.write(params.getBytes());
      bout.flush();
      
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line);
      }
      
      /* 정상 처리 상황의 응답 처리 (try 블록의 응답은 $.ajax({success: function(resData)})로 전달됨) */
      
      // 응답 타입과 인코딩 (파파고 API 응답 결과는 JSON으로 제공됨)
      response.setContentType("application/json; charset=UTF-8");
      
      // 응답 출력 스트림 생성
      PrintWriter out = response.getWriter();
      
      // 응답하기
      out.println(sb.toString());
      out.flush();
      out.close();
      
    } catch (Exception e) {
      
      /* 예외 상황의 응답 처리 (catch 블록의 응답은 $.ajax({error: function(jqXHR)})로 전달됨) */
      
      // 응답 타입과 인코딩 (예외 메시지를 text 형식으로 반환함)
      response.setContentType("text/plain; charset=UTF-8");
      
      // 예외 메시지 Text
      String message = e.getMessage();

      // 응답 출력 스트림 생성
      PrintWriter out = response.getWriter();
      
      // 응답하기
      out.println(message);
      out.flush();
      out.close();
      
    } finally {
      try {
        if(reader != null) reader.close();
        if(bout != null) bout.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
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
