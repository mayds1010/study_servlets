package com.yojulab.study_servlets.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatcherServlets")
public class DispatcherServlets extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
   String hiddenParam = request.getParameter("hiddenParam");

   // /dispatcherServlets?hiddenParam=searchFormServlet
    if("searchFormServlet".equals(hiddenParam)){
        response.sendRedirect("/searchFormServlet");//a태그와 같음 ,파라미터 포함해서 보내지 못함 ,호출만 하기
   //sendRedirect 웹 서버가 웹 브라우저에게 다른 페이지로 이동하라고 응답하는 기능

        // /dispatcherServlets?hiddenParam=createCookieServlets
    }else if("createCookieServlets".equals(hiddenParam)){
        request.setAttribute("firstName", "yojulab");
        //setAttribute 메서드는 선택한 요소의 속성 값을 설정
        RequestDispatcher requestDispatcher =  request.getRequestDispatcher("/cookies/createServlets");
        //requestDispatcher 현재 request에 담긴 정보를 저장하고 있다 다음 페이지에서도 해당 정보를 볼 수있게 계속 저장하는 기능
        requestDispatcher.forward(request, response); 
        //forward  클라이언트가 웹서버에 forward01.jsp를 요청, forward01.jsp에서 작성된 코드에의해 포워딩되어 forward02.jsp를 반환
    }else{
        //normal display
         String message = "HelloWorldServlets with Message!";
         PrintWriter printWriter = response.getWriter();
     
             printWriter.println("<html lang='en'>");
             printWriter.println("<head>");
             printWriter.println("<title>"+message+"</title>"); 
             printWriter.println("</head>");
             printWriter.println("<body>");
             printWriter.println("<button>call DispatcherServlets</button>");
             printWriter.println("</form>");
             printWriter.println("</body>");
             printWriter.println("</html>");
     
            
             printWriter.close();//response됨
    }
    }
}
