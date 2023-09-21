package service;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;
import domain.BookDto;
import repository.BookDao;
import util.PageVo;

public class BookServiceImpl implements BookService {
  
  // 모든 서비스가 공동으로 사용하는 BookDao, PageVo 객체 가져오기
  private BookDao dao = BookDao.getDao(); 
  private PageVo pageVo = new PageVo();
  
  @Override
  public ActionForward getBookByNo(HttpServletRequest request) {
    
    
    return null;
  }
  
  @Override
  public ActionForward getBookList(HttpServletRequest request) {
    
    //page, total, display 정보가 있어야 목록을 가져올수 있다. 
    
    // 전달된 페이지 목록(페이지 번호의 전달이 없으면 1 페이지를 연다. )
    Optional<String> opt= Optional.ofNullable(request.getParameter("page"));
    int page = Integer.parseInt(opt.orElse("1"));
    
    int total = dao.bookCount();
    
    int display = 5; 
    
    // pageVo의 모든 정보 계산하기
    pageVo.setPaging(page, total, display);
    
    // 게시글 목록을 가져올 때 사용할 변수들을 Map으로 만듬
    Map<String, Object> 

    return null;
  }
  
  @Override
  public ActionForward register(HttpServletRequest request) {
    //등록할 책이름과 저자, 가격
      String title = request.getParameter("title");
      String author = request.getParameter("author");
      int price = Integer.parseInt(request.getParameter("price"));
      
      // 책이름 + 저자 + 가격 -> BookDto 객체
      BookDto dto = BookDto.builder()
                        .title(title)
                        .author(author)
                        .price(price)
                        .build();
      // BookDao의 register 메소드 호출 
      int bookAddResult = dao.bookAdd(dto);
      
      // 등록 성공(bookAddResult ==1, 0-> 실패)
      String path = null;
      
     if(bookAddResult == 1) {
       path = request.getContextPath() + "/book/list.do";      
     } else if(bookAddResult == 0) {
       path = request.getContextPath() + "/index.do";
     }
      
     // 어디로 어떻게 이동하는지 반환(insert 수행 후에는 반드시 리다이렉트로 이동한다. ) 
      
      
    return new ActionForward(path, true);
  }
  
 
  @Override
  public ActionForward edit(HttpServletRequest request) {


    return null;
  }
  
  @Override
  public ActionForward modify(HttpServletRequest request) {


    return null;
  
  
  }@Override
  public ActionForward delete(HttpServletRequest request) {


    return null;
  }
  
}
