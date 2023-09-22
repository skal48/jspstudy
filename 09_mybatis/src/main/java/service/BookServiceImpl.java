package service;

import java.util.HashMap;
import java.util.List;
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
    
    //상세 조회할 게시글의 번호 
    Optional<String> opt = Optional.ofNullable(request.getParameter("book_no"));
    int book_no = Integer.parseInt(opt.orElse("0"));
    
    //DB로 부터 게시글 가져 오기
    BookDto book = dao.bookDetail(book_no);
    
    //게시글을 /book/detial.jsp 에 전달하기 위해서 forward 처리
    request.setAttribute("book", book);
     
    return new ActionForward("/book/detail.jsp", false);
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
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("begin", pageVo.getBegin());
    map.put("end", pageVo.getEnd());
    
    //DB로 부터 게시들 목록 가져오기 
    List<BookDto> BookList = dao.bookList(map);
    
    //게시글 목록과 paging을 book/list.jsp로 전달하기 위하여 request에 저장한뒤 forward한다. 
    request.setAttribute("bookList", BookList);
    request.setAttribute("paging", pageVo.getPaging(request.getContextPath() + "/book/list.do"));

    return new ActionForward("/book/list.jsp",false);
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
    
    // 상세조회할 게시글의 번호 
    Optional<String> opt = Optional.ofNullable(request.getParameter("book_no"));
    int book_no= Integer.parseInt(opt.orElse("0"));
    
    //DB로부터  게시글 가져오기
    BookDto book = dao.bookDetail(book_no);
    
    //게시글을 /book/edit.jsp 에 전달하기 위해서 forward 처리
    request.setAttribute("book", book);
    
    return new ActionForward("/book/edit.jsp", false);
    
  }
  
  @Override
  public ActionForward modify(HttpServletRequest request) {
    //수정할 게시글 정보
    String title = request.getParameter("title");
    String author = request.getParameter("author");
    int price = Integer.parseInt(request.getParameter("price"));
    int book_no = Integer.parseInt(request.getParameter("book_no"));
    
    // 수정할 게시글 정보를 BookDto의 객체로 생성
    BookDto dto = BookDto.builder()
                       .title(title) 
                       .author(author)
                       .price(price)
                       .bookNo(book_no)
                       .build();
    //수정하기 
    int modifyResult = dao.bookModify(dto);
    
    //수정 성공(modifyResult == 1), 수정 실패(ModifyResult == 0)
    
    String path = null;
    
    if(modifyResult == 1) {
      path = request.getContextPath() + "/book/detail.do?book_no=" + book_no;
    } else {
      path=request.getContextPath() + "/index.do";
    }

    //update 이후에는 redirect 한다.
    return new ActionForward(path, true);
  
  
  }@Override
  public ActionForward delete(HttpServletRequest request) {
    // 삭제할 책 번호 
    Optional<String> opt = Optional.ofNullable(request.getParameter("book_no"));
    int book_no = Integer.parseInt(opt.orElse("0"));
    
    int deleteResult = dao.bookDelete(book_no);
    
    //삭제 성공(deleteResult == 1 ), 삭제 실패 (deleteResult == 0)
    String path = null;
    if(deleteResult == 0) {
      path = request.getContextPath() + "book/list.do";
    } else if(deleteResult == 0) {
      path = request.getContextPath() + "/index.do";
    }
    
    //delete 이후에는 redirect 한다.  
    return new ActionForward(path, true);
  }
  
}
