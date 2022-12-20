package com.yojulab.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// /session/createServlets?username=yojulab&password=1234
@WebServlet(urlPatterns="/session/getServlets")
public class GetSessionServlets extends HttpServlet{ //로그인때 사용
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
    

        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>Create Session Servlets</div>");
        
       // login되는 상태 
            HttpSession httpSession = request.getSession();
          String username = (String)httpSession.getAttribute("username");
          String password = (String)httpSession.getAttribute("password");
           
          printWriter.println("<div>"+username+", "+password+"</div>");
       
        printWriter.close();
    }
}
