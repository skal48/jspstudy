<<<<<<< HEAD
package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {
 public void getMemberList(HttpServletResponse response) throws IOException;
 public void memberAdd(HttpServletRequest request, HttpServletResponse response) throws IOException;
 public void memberEmailCheck(HttpServletRequest request, HttpServletResponse response) throws IOException;
 public void memberDetail(HttpServletRequest request, HttpServletResponse response) throws IOException;
 public void memberModify(HttpServletRequest request, HttpServletResponse response) throws IOException;
 public void memberDelete(HttpServletRequest request, HttpServletResponse response) throws IOException;
 
 
}
=======
package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {
 public void getMemberList(HttpServletResponse response) throws IOException;
 public void memberAdd(HttpServletRequest request, HttpServletResponse response) throws IOException;
 public void memberEmailCheck(HttpServletRequest request, HttpServletResponse response) throws IOException;
 public void memberDetail(HttpServletRequest request, HttpServletResponse response) throws IOException;
 public void memberModify(HttpServletRequest request, HttpServletResponse response) throws IOException;
 public void memberDelete(HttpServletRequest request, HttpServletResponse response) throws IOException;
 
 
}
>>>>>>> b1d84188f6ee1ea63b05f3c716c20782a6b349f2
